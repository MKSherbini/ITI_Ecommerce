<%--
  Created by IntelliJ IDEA.
  User: Hadeer
  Date: 29-Mar-21
  Time: 4:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="commons/pageCommon.jsp" %>
<html>
<head>
    <title>Title</title>
    <%@include file="commons/headCommon.jsp" %>
</head>
<body class="config">
<div class="preloader is-active">
    <div class="preloader__wrap">

        <img class="preloader__img" src="images/preloader.png" alt=""></div>
</div>
<div id="app">

    <!--====== Main Header ======-->
    <%@ include file="commons/headerCommon.jsp" %>
    <div class="app-content">
        <div class="section__content">
            <div class="container">
                <div class="row row--center">
                    <div class="col-lg-6 col-md-8 u-s-m-b-30">
                        <div class="l-f-o">
                            <div class="l-f-o__pad-box">

                                <h1 class="gl-h1">Add New Product</h1>
                                <form class="l-f-o__form" action="addproduct" method="post" name="addproduct" enctype="multipart/form-data"
                                      id="addproduct">
                                    <div class="u-s-m-b-30">

                                        <label class="gl-label" for="name">Product Name *</label>


                                        <input class="input-text input-text--primary-style" type="text" name="name"
                                               id="name" required onblur="validateemail()"
                                               placeholder="Enter Product Name">
                                        <label style='color: red' ; id="error-name"></label>

                                    </div>
                                    <div class="u-s-m-b-30">

                                        <label class="gl-label" for="image">Product Image *</label>

                                        <input class="input-text input-text--primary-style" type="file" name="image"
                                               id="image" required onblur="validateemail()"
                                               placeholder="Enter Product Image">
                                        <label style='color: red' id="error-image"></label>

                                    </div>
                                    <div class="u-s-m-b-30">

                                        <label class="gl-label" for="productDescription">Product Description *</label>

                                        <textarea style="padding: 10px;" class="input-text input-text--primary-style"
                                                  name="productDescription" id="productDescription"
                                                  onblur="validatePass()" rows="20" cols="30" required
                                                  placeholder="Enter Product Description" form="addproduct"></textarea>
                                        <label style='color: red' id="error-desc"></label>
                                    </div>
                                    <div class="u-s-m-b-30">

                                        <%-- select categoryy--%>
                                        <select name="category" required>
                                            <c:forEach items="${requestScope.categories}" var="category">
                                                <option name="category" value="${category}">${category}</option>
                                            </c:forEach>
                                        </select>
                                        <!--====== End - Check Box ======-->
                                    </div>
                                    <div class="u-s-m-b-30">

                                        <label class="gl-label" for="price">Product Price *</label>

                                        <input class="input-text input-text--primary-style" type="number" name="price"
                                               id="price" required onblur="validateemail()"
                                               placeholder="Enter Product Price">
                                        <label style='color: red' id="error-price"></label>

                                    </div>
                                    <div class="u-s-m-b-30">

                                        <label class="gl-label" for="quantity">Product Quantity *</label>

                                        <input class="input-text input-text--primary-style" type="number" name="quantity"
                                               id="quantity" required onblur="validateemail()"
                                               placeholder="Enter Product Quantity">
                                        <label style='color: red' id="error-quantity"></label>

                                    </div>
                                    <div class="u-s-m-b-30">

                                        <label class="gl-label" for="discount">Product Discount Percentage *</label>

                                        <input class="input-text input-text--primary-style" type="number" name="discount"
                                               id="discount" required onblur="validateemail()"
                                               placeholder="Enter Product Quantity">
                                        <label style='color: red' id="error-discount"></label>

                                    </div>
                                    <div class="u-s-m-b-30">

                                        <button class="btn btn--e-transparent-brand-b-2" type="submit">Add Product
                                        </button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!--====== End - Section Content ======-->
    </div>
</div>
</div>
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
