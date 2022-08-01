<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<section class="vh-100" style="background-color: #eee;">
    <div class="container py-5">
        <div class="row justify-content-center align-items-center">
            <div class="col-12 col-lg-9 col-xl-7">
                <div class="card shadow-2-strong card-registration" style="border-radius: 15px;">
                    <div class="card-body p-4 p-md-5">
                        <h3 class="mb-4 pb-2 pb-md-0 mb-md-5">Registration Form</h3>
                        <form:form method="POST"
                                   action="/users/register" modelAttribute="userDto">

                            <div class="row">
                                <div class="col-md-6 mb-4">

                                    <div class="form-outline">
                                        <form:input type="text" class="form-control form-control-lg" placeholder="First Name" path="firstName"/>
                                    </div>

                                </div>
                                <div class="col-md-6 mb-4">

                                    <div class="form-outline">
                                        <form:input type="text" class="form-control form-control-lg" placeholder="Last Name" path="lastName"/>
                                    </div>

                                </div>
                            </div>

                            <div class="row">
                                <div class="col-md-6 mb-4 pb-2">

                                    <div class="form-outline">
                                        <form:input type="email" class="form-control form-control-lg" placeholder="Email"  path="email"/>
                                    </div>

                                </div>
                                <div class="col-md-6 mb-4 pb-2">

                                    <div class="form-outline">
                                        <form:input type="text" class="form-control form-control-lg" placeholder="Username" path="login"/>
                                    </div>

                                </div>
                            </div>

                            <div class="row">
                                <div class="col-md-6 mb-4 pb-2">

                                    <div class="form-outline">
                                        <form:input type="text" class="form-control form-control-lg" placeholder="PESEL" path="pesel"/>
                                    </div>

                                </div>
                                <div class="col-md-6 mb-4 pb-2">

                                    <div class="form-outline">
                                        <form:input type="tel" class="form-control form-control-lg" placeholder="Phone Number" path="phone"/>
                                    </div>

                                </div>
                            </div>

                            <div class="row">
                                <div class="col-md-6 mb-4 pb-2">

                                    <div class="form-outline">
                                        <form:input type="password" class="form-control form-control-lg" placeholder="Password" path="password"/>
                                    </div>

                                </div>
                            </div>

                            <div class="mt-4 pt-2">
                                <input class="btn btn-primary btn-lg" type="submit" value="Submit" />
                            </div>

                        </form:form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>