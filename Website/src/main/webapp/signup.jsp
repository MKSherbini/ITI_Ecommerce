<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="commons/pageCommon.jsp" %>

<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="commons/pageCommon.jsp" %>
<html class="no-js" lang="en">
<head>
    <title>${applicationScope.urlMappingConstants.getTitle(PageNames.REGISTER_PAGE)}</title>
    <%@include file="commons/headCommon.jsp" %>
    <script src="scripts/js/signup.js"></script>
</head>
<body class="config">
<div class="preloader is-active">
    <div class="preloader__wrap">

        <img class="preloader__img" src="images/preloader.png" alt=""></div>
</div>

<!--====== Main App ======-->
<div id="app">

    <!--====== Main Header ======-->
    <header class="header--style-1 header--box-shadow">
        <%@include file="commons/headerCommon.jsp" %>
    </header>
    <!--====== End - Main Header ======-->


        <!--====== App Content ======-->
        <div class="app-content">

            <!--====== Section 1 ======-->
            <div class="u-s-p-y-60">

                <!--====== Section Content ======-->
                <div class="section__content">
                    <div class="container">
                        <div class="breadcrumb">
                            <div class="breadcrumb__wrap">
                                <ul class="breadcrumb__list">
                                    <li class="has-separator">

                                        <a href="${applicationScope.urlMappingConstants.getControllerUrl(PageNames.HOME_PAGE)}">Home</a></li>
                                    <li class="is-marked">

                                        <a href="signup.jsp">Signup</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!--====== End - Section 1 ======-->


            <!--====== Section 2 ======-->
            <div class="u-s-p-b-60">

                <!--====== Section Intro ======-->
                <div class="section__intro u-s-m-b-60">
                    <div class="container">
                        <div class="row">
                            <div class="col-lg-12">
                                <div class="section__text-wrap">
                                    <h1 class="section__heading u-c-secondary">CREATE AN ACCOUNT</h1>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!--====== End - Section Intro ======-->


                <!--====== Section Content ======-->
                <div class="section__content">
                    <div class="container">
                        <div class="row row--center">
                            <div class="col-lg-6 col-md-8 u-s-m-b-30">
                                <div class="l-f-o">
                                    <div class="l-f-o__pad-box">
                                        <h1 class="gl-h1">PERSONAL INFORMATION</h1>
                                        <form class="l-f-o__form" method="post" action="signup">
                                            <div class="u-s-m-b-30">

                                                <label class="gl-label" for="reg-fname">FIRST NAME *</label>

                                                <input class="input-text input-text--primary-style" name="firstName" type="text" id="reg-fname" placeholder="First Name" required></div>
                                            <div class="u-s-m-b-30">

                                                <label class="gl-label" for="reg-lname">LAST NAME *</label>

                                                <input class="input-text input-text--primary-style" name="lastName" type="text" id="reg-lname" placeholder="Last Name" required></div>
                                            <div class="u-s-m-b-30">

                                                <label class="gl-label" for="userName">USERNAME *</label>

                                                <input class="input-text input-text--primary-style" name="userName" type="text" id="userName" placeholder="UserName" required></div>
                                            <div class="gl-inline">
                                                <div class="u-s-m-b-30">

                                                    <!--====== Date of Birth Select-Box ======-->

                                                    <span class="gl-label">BIRTHDAY</span>
                                                    <div class="gl-dob">
                                                        <input type="date" name="birthDate" class="select-box select-box--primary-style u-w-100">
                                                    </div>
                                                    <!--====== End - Date of Birth Select-Box ======-->
                                                </div>
                                                <div class="u-s-m-b-30">

                                                    <label class="gl-label" for="gender">GENDER</label><select name="gender" class="select-box select-box--primary-style u-w-100" id="gender">
                                                        <option selected>Select</option>
                                                        <option value="male">Male</option>
                                                        <option value="male">Female</option>
                                                    </select></div>
                                            </div>
                                            <div class="u-s-m-b-30">

                                                <label class="gl-label" for="reg-email">E-MAIL *</label>

                                                <input class="input-text input-text--primary-style" name="email" type="email" id="reg-email" placeholder="Enter E-mail" required onblur="validateEmail(this.value)"><label class="gl-label" style='color: red' ; id="emailValid" ></label></div>

                                            <div class="u-s-m-b-30">

                                                <label class="gl-label" for="reg-password">PASSWORD *</label>

                                                <input class="input-text input-text--primary-style" name="password" type="password" id="reg-password" placeholder="Enter Password" required maxlength="15" onblur="validatePassword()"><label class="gl-label" style='color: red' ; id="passwordValid"></label></div>

                                            <div class="u-s-m-b-15">

                                                <label class="gl-label" for="reg-repassword">Reenter PASSWORD *</label>

                                                <input class="input-text input-text--primary-style" type="password" id="reg-repassword" placeholder="Reenter Password" required maxlength="15" onblur="validatePassword()"><label class="gl-label" style='color: red' ; id="repasswordValid"></label></div>
                                            <div class="u-s-m-b-15">

                                                <button class="btn btn--e-transparent-brand-b-2" type="submit">Sign Up</button></div>

                                            <a class="gl-link" href="#">Return to Store</a>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!--====== End - Section Content ======-->
            </div>
            <!--====== End - Section 2 ======-->
        </div>
        <!--====== End - App Content ======-->


        <!--====== Footer ======-->
        <jsp:include page="commons/footerCommon.jsp"/>
        <!--====== End - Footer ======-->

    </div>
    <!--====== End - Main App ======-->


    <!--====== Google Analytics: change UA-XXXXX-Y to be your site's ID ======-->
    <script>
        window.ga = function() {
            ga.q.push(arguments)
        };
        ga.q = [];
        ga.l = +new Date;
        ga('create', 'UA-XXXXX-Y', 'auto');
        ga('send', 'pageview')

        function call(){
            var kcyear = document.getElementsByName("year")[0],
                kcmonth = document.getElementsByName("month")[0],
                kcday = document.getElementsByName("day")[0];

            var d = new Date();
            var n = d.getFullYear();
            for (var i = n; i >= 1950; i--) {
                var opt = new Option();
                opt.value = opt.text = i;
                kcyear.add(opt);
            }
            kcyear.addEventListener("change", validate_date);
            kcmonth.addEventListener("change", validate_date);

            function validate_date() {
                var y = +kcyear.value, m = kcmonth.value, d = kcday.value;
                if (m === "2")
                    var mlength = 28 + (!(y & 3) && ((y % 100) !== 0 || !(y & 15)));
                else var mlength = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31][m - 1];
                kcday.length = 0;
                for (var i = 1; i <= mlength; i++) {
                    var opt = new Option();
                    opt.value = opt.text = i;
                    if (i == d) opt.selected = true;
                    kcday.add(opt);
                }
            }
            validate_date();
        }
    </script>
    <script src="https://www.google-analytics.com/analytics.js" async defer></script>

    <!--====== Vendor Js ======-->
    <script src="scripts/js/vendor.js"></script>

    <!--====== jQuery Shopnav plugin ======-->
    <script src="scripts/js/jquery.shopnav.js"></script>

    <!--====== App ======-->
    <script src="scripts/js/app.js"></script>

    <!--====== Noscript ======-->
    <noscript>
        <div class="app-setting">
            <div class="container">
                <div class="row">
                    <div class="col-12">
                        <div class="app-setting__wrap">
                            <h1 class="app-setting__h1">JavaScript is disabled in your browser.</h1>

                            <span class="app-setting__text">Please enable JavaScript in your browser or upgrade to a JavaScript-capable browser.</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </noscript>
</body>
</html>