<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<div class="container mt-5">
    <div class="main-body">
        <div class="row gutters-sm">
            <div class="col-md-4 mb-3">
                <div class="card">
                    <div class="card-body">
                        <div class="d-flex flex-column align-items-center text-center">
                            <img src="https://wallpaperaccess.com/full/2910510.jpg" alt="Admin" class="rounded-circle" width="300">
                            <div class="mt-3">
                                <h4>${car.brand} ${car.model} </h4>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-8">
                <div class="card mb-3">
                    <div class="card-body">
                        <div class="row">
                            <div class="col-sm-3">
                                <h6 class="mb-0">Price</h6>
                            </div>
                            <div class="col-sm-9 text-secondary">
                                ${car.dailyFee}$/day
                            </div>
                        </div>
                        <hr>
                        <div class="row">
                            <div class="col-sm-3">
                                <h6 class="mb-0">Car Status</h6>
                            </div>
                            <div class="col-sm-9 text-secondary">
                                ${car.carStatus}
                            </div>
                        </div>
                        <hr>
                        <div class="row">
                            <div class="col-sm-3">
                                <h6 class="mb-0">Registration</h6>
                            </div>
                            <div class="col-sm-9 text-secondary">
                                ${car.registration}
                            </div>
                        </div>
                        <sec:authorize access="hasAnyRole('ROLE_ADMIN')">
                            <hr>
                            <div class="row">
                                <div class="col-sm-12">
                                    <a class="btn btn-info " target="__blank" href="https://www.bootdey.com/snippets/view/profile-edit-data-and-skills">Edit</a>
                                </div>
                            </div>
                        </sec:authorize>
                    </div>
                </div>
            </div>
        </div>

        <section>
            <div class="container my-5 py-5 text-dark">
                <div class="row">
                    <div class="col-md-12 col-lg-10 col-xl-8">
                        <div class="d-flex justify-content-between align-items-center mb-4">
                            <h4 class="text-dark mb-0">Comments</h4>
                        </div>

                        <c:forEach items="${car.comments}" var="comment">
                        <div class="card mb-3">
                            <div class="card-body">
                                <div class="d-flex flex-start">
                                    <img class="rounded-circle shadow-1-strong me-3"
                                         src="https://mdbcdn.b-cdn.net/img/Photos/Avatars/img%20(26).webp" alt="avatar" width="40"
                                         height="40" />
                                    <div class="w-100">
                                        <div class="d-flex justify-content-between align-items-center mb-3">
                                            <h6 class="text-primary fw-bold mb-0">
                                                    ${comment.login}
                                                <span class="text-dark ms-2">${comment.text}</span>
                                                        <span class="text-dark ms-2">Rating - ${comment.rating}</span>
                                            </h6>
                                            <p class="mb-0">${comment.creationDate}</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </section>
    </div>
</div>