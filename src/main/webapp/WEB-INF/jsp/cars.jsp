<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<div class="row d-flex justify-content-center">
    <c:forEach items="${cars}" var="car">
        <div class="card me-4" style="width: 18rem;">
            <img src="https://wallpaperaccess.com/full/2910510.jpg" class="card-img-top" alt="...">
            <div class="card-body">
                <h5 class="card-title">${car.brand} ${car.model}</h5>
                <p class="m-0">${car.dailyFee}$/day</p>
                <p class="m-0">${car.location.country} ${car.location.city}</p>
                <p class="m-0">${car.location.address}</p>
            </div>
            <div class="card-body">
                <a href="/cars/ + ${car.id}" class="card-link">More details...</a>
            </div>
        </div>
    </c:forEach>
</div>

