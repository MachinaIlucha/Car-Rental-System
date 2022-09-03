# Car rental system

I wrote this project to get familiar how jsp works and how i can use it in my future projects.
I hope I coped well with this task at least at the initial level.
I also handle how to use dto to collect data.

## About project

It's basic MVC spring boot application with PostgreSQL database.
With this application, users will be able to rent car.

### Libraries i have used

As you can see in my pom.xml i mostly used spring starters, also i added some more dependencies:

- spring-boot-starter-web
- spring-boot-starter-data-jpa
- spring-boot-starter-security
- spring-security-taglibs
- spring-boot-starter-test
- postgresql
- lombok
- validation-api
- tomcat-embed-jasper
- jstl
- bootstrap
- bootstrap-datepicker

## Tests
I have onlu one test in this project to check if findAllUsers will work correctly and return correct json.
```java
@WebMvcTest(UserController.class)
class CarRentalSystemApplicationTests {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper mapper;

    @MockBean
    UserRepository userRepository;


    User RECORD_1 = new User(1L, "test name 1", "test last name 1", "test login 1",
            "pass 1", "email 1", "phone 1",
            "12345678910", new HashSet<>() {{add(new Role(1L, RoleName.CUSTOMER));}});
    User RECORD_2 = new User(2L, "test name 2", "test last name 2", "test login 2",
            "pass 2", "email 2", "phone 2",
            "12345678910", new HashSet<>() {{add(new Role(1L, RoleName.CUSTOMER));}});
    User RECORD_3 = new User(3L, "test name 3", "test last name 3", "test login 3",
            "pass 3", "email 3", "phone 3",
            "12345678910", new HashSet<>() {{add(new Role(1L, RoleName.CUSTOMER));}});

    @Test
    public void getAllRecords_success() throws Exception {
        List<User> userList = new ArrayList<>(Arrays.asList(RECORD_1, RECORD_2, RECORD_3));

        Mockito.when(userRepository.findAll()).thenReturn(userList);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/users")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect((ResultMatcher) jsonPath("$[2].firstName", is("test name 2")));
    }
}
```

## A few end-points of my application: 

- GET  /booking                             - get all bookings
- POST /booking/addBooking                  - save booking
- GET  /booking/{bookingId}                 - get booking by id
- GET  /users/{userId}                      - get all bookings by user
- DELETE  /booking/{bookingId}              - delete booking with certain id

### End-point that provide cars information:
- GET  /cars                    - get all cars
- GET  /cars/{carId}            - get car by id
- PUT  /cars/updateCar          - update car
- POST /cars/addCar             - save flight

### End-point that provide comments information:
- GET  /comments/{carId}/all       - get all comments for car
- GET  /comments/{carId}            - add comment to car

### End-point that provide users information:
- POST  /users/register                 - register user
- GET   /users  - get all users
- GET   /users/my-profile - get profile of authorize user
- GET   /users/{userId} - get user by id
- PUT   /users/{userId} - update user with certain id
- PUT   /users/{userId}/addRole - add new role to user
