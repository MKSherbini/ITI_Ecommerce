<!--====== Main Footer ======-->
<script src="scripts/js/footer.js" type="text/javascript"></script>
<footer>
    <div class="outer-footer">
        <div class="container">
            <div class="row">
                <div class="col-lg-4 col-md-6">
                    <div class="outer-footer__content u-s-m-b-40">

                        <span class="outer-footer__content-title">Contact Us</span>
                        <div class="outer-footer__text-wrap"><i class="fas fa-home"></i>

                            <span>28 Smart Village Giza , Egypt</span></div>
                        <div class="outer-footer__text-wrap"><i class="fas fa-phone-volume"></i>

                            <span>(+20) 102 312 2579</span></div>
                        <div class="outer-footer__text-wrap"><i class="far fa-envelope"></i>

                            <span>contact@ludus.com</span></div>
                        <div class="outer-footer__social">
                          <%--  <ul>
                                <li>

                                    <a class="s-fb--color-hover" href="www.facebook.com"><i class="fab fa-facebook-f"></i></a></li>
                                <li>

                                    <a class="s-tw--color-hover" href="www.twitter.com"><i class="fab fa-twitter"></i></a></li>
                                <li>

                                    <a class="s-youtube--color-hover" href="www.youtube.com"><i class="fab fa-youtube"></i></a></li>
                                <li>

                                    <a class="s-insta--color-hover" href="www.instgram.com"><i class="fab fa-instagram"></i></a></li>
                                <li>

                                    <a class="s-gplus--color-hover" href="#"><i class="fab fa-google-plus-g"></i></a></li>
                            </ul>--%>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4 col-md-6">
                    <div class="row">
                        <div class="col-lg-6 col-md-6">
                            <div class="outer-footer__content u-s-m-b-40">

                                <span class="outer-footer__content-title">Information</span>
                                <div class="outer-footer__list-wrap">
                                    <ul>
                                        <li>

                                            <a href="cart">Cart</a></li>
                                        <li>
<%--                                            // todo link  to the account of the user --%>
                                            <a href="userDash">Account</a></li>


                                        <li>
                                            <%--                                            // todo link  to the home --%>
<%--                                            <a href="shop">Shop</a></li>--%>

<%--                                            <a href="dash-payment-option.jsp">Finance</a></li>--%>
                                        <li>

                                            <a href="shop">Shop</a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-6 col-md-6">
                            <div class="outer-footer__content u-s-m-b-40">
                                <div class="outer-footer__list-wrap">

                                    <span class="outer-footer__content-title">Our Company</span>
                                    <ul>
                                        <li>

                                            <a href="about">About us</a></li>
                                        <li>

                                            <a href="contact">Contact Us</a></li>
                                        <li>
                                            <a href="home">Sitemap</a></li>
                                        <%--<li>
                                            &lt;%&ndash; // todo link  to the orders page  &ndash;%&gt;
                                            <a href="${applicationScope.urlMappingConstants.getControllerUrl(PageNames.MY_ORDERS)}">Delivery</a></li>--%>
                                        <li>

<%--                                            <a href="${applicationScope.urlMappingConstants.getControllerUrl(PageNames.SHOP)}">Store</a></li>--%>
<%--                                            <a href="${applicationScope.urlMappingConstants.getControllerUrl(PageNames.SHOP)}">Store</a></li>--%>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4 col-md-12">
                    <div class="outer-footer__content">

                        <span class="outer-footer__content-title">Join our Newsletter</span>
                        <form class="newsletter" id="subscibe_form">
                            <div class="u-s-m-b-15">
                                <div class="radio-box newsletter__radio">

                                    <input type="radio" id="male" name="gender" value="Male">
                                    <div class="radio-box__state radio-box__state--primary">

                                        <label class="radio-box__label" for="male">Male</label></div>
                                </div>
                                <div class="radio-box newsletter__radio">

                                    <input type="radio" id="female" name="gender" value="Female">
                                    <div class="radio-box__state radio-box__state--primary">

                                        <label class="radio-box__label" for="female">Female</label></div>
                                </div>
                            </div>
                            <div class="newsletter__group">

                                <label for="newsletter"></label>

                                <input class="input-text input-text--only-white" type="text" id="newsletter" placeholder="Enter your Email">

                                <button class="btn btn--e-brand newsletter__btn" type="submit">SUBSCRIBE</button></div>
                            <span class="newsletter__text ui-state-error-text" display="none" id="error_message">you must choose Gender and enter valid email like : example@gmail.com .</span>
                            <span class="newsletter__text" id="success_message">Subscribe to the mailing list to receive updates on promotions, new arrivals, discount and coupons.</span>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="lower-footer">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="lower-footer__content">
                        <div class="lower-footer__copyright">

                            <span>Copyright © 2021 </span>

                            <a href="${applicationScope.urlMappingConstants.getControllerUrl(PageNames.HOME_PAGE)}">Reshop</a>

                            <span>All Right Reserved</span></div>
                        <div class="lower-footer__payment">
                            <ul>
                                <li><i class="fab fa-cc-stripe"></i></li>
                                <li><i class="fab fa-cc-paypal"></i></li>
                                <li><i class="fab fa-cc-mastercard"></i></li>
                                <li><i class="fab fa-cc-visa"></i></li>
                                <li><i class="fab fa-cc-discover"></i></li>
                                <li><i class="fab fa-cc-amex"></i></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</footer>
