<template>
  <div class="home-container">
    <!-- LOAD PAGE -->
    <div class="animationload">
        <div class="loader"></div>
    </div>
    <!-- BACK TO TOP SECTION -->
    <a href="#top" class="cd-top cd-is-visible cd-fade-out">Top</a>
    <!-- 头部区域 -->
    <div class="header header-1">
        <!-- 顶部 -->
        <div class="middlebar d-none d-sm-block">
            <div class="container">
                <div class="row align-items-center">
                    <div class="col-3 col-md-3">
                        <div class="logo">
                            <img src="images/logo.png" alt="" />
                        </div>
                    </div>
                    <div class="col-9 col-md-9">
                        <div class="contact-info">
                            <div class="rs-icon-1">
                                <div class="icon">
                                    <div class="fas fa-envelope"></div>
                                </div>
                                <div class="body-content">
                                    <div class="heading">Email Support :</div>
                                    info@subsco.com
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- 导航栏 -->
        <div class="navbar-main">
            <div class="container">
                <nav id="navbar-example" class="navbar navbar-expand-lg navbar-bg">
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarNavDropdown">
                        <ul class="navbar-nav">
                            <li class="nav-item">
                                <a class="nav-link" href="index.html">Home</a>
                            </li>

                            <li class="nav-item">
                                <a class="nav-link" href="#section">About</a>
                            </li>

                            <li class="nav-item">
                                <a class="nav-link" href="#footer">Contact</a>
                            </li>

                        </ul>
                    </div>
                </nav> <!-- Navbar -->

            </div>
        </div>

    </div>
    
    <search></search>
    <div class="section bg-primary">
      <div class="owl-carousel owl-theme full-screen">
        <div class="item">
            <div class="overlay-bg"></div>
            <div class="container align-items-center h-center">
                <div class="wrap-caption">
                    <h1 class="caption-heading text-white">Engineering your dreams with us</h1>
                    <input type="text" class="search keyword" placeholder="Search Company" v-model="input" @keyup.enter="trans" />
                    <button class="btn btn-primary" type="button" @click="trans">Search</button>
                    <!--a href="#" class="btn btn-secondary">Contact Us</a-->
                </div>
              </div>
        </div>
      </div>
    </div>

    <!-- ABOUT介绍栏 -->
    <div class="section" id="section">
        <div class="content-wrap">
            <div class="container">
                <div class="row">
                    <div class="col-sm-4 col-md-4">
                        <h4 class="section-heading text-black no-after mb-3">
                            About <span class="text-primary">Us</span>
                        </h4>
                        <h3 class="text-black">
                            Creating quality urban lifestyles, building stronger communities
                        </h3>
                        <p>We provide a professional dignissim at cursus elefeind norma arcu. Pellentesque accumsan est in tempus etos ullamcorper sem quam suscipit lacus maecenas tortor.</p>
                        <!--a href="#" class="btn btn-secondary">Our projects</a-->
                        <div class="spacer-30"></div>
                    </div>
                    <div class="col-sm-8 col-md-8 pleft">
                        <div class="img-subsco">
                            <img src="images/dummy-img-1200x800.jpg" alt="" class="img-fluid">
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- CTA contact us -->
    <div class="section bg-primary">
        <div class="content-wrap py-5">
            <div class="container">
                <div class="row align-items-center cta-block-1">
                    <div class="col-sm-8 col-md-8">
                        <h4 class="my-1 text-black">Don't hesitate to contact us any time</h4>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- FOOTER SECTION页尾联系信息 -->
    <div class="footer" id="footer">
        <div class="content-wrap">
            <div class="container">

                <div class="row">

                    <div class="col-sm-6 col-md-6 col-lg-4">
                        <div class="footer-item">
                            <img src="images/logo-light.png" alt="logo bottom" class="logo-bottom">
                            <div class="spacer-30"></div>
                            <p>Nam eu laoreet dui, quis aliquet neque. Phasellus accumsan nibh nibh, sit amet vehicula mauris porta quis.</p>

                            <ul class="list-info my-4">
                                <li>
                                    <div class="info-icon uk21">
                                        <span class="fas fa-phone-alt"></span>
                                    </div>
                                    <div class="info-text uk21"><strong>+62-123 014 6789</strong></div>
                                </li>
                            </ul>
                        </div>
                    </div>

                    <div class="col-sm-6 col-md-6 col-lg-4">
                        <div class="footer-item">
                            <div class="footer-title">
                                Additional Menu
                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <ul class="list">
                                        <li><a href="#" title="Home">Home</a></li>
                                        <li><a href="#" title="Pages">Pages</a></li>
                                        <li><a href="#" title="Contact">Contact</a></li>
                                    </ul>
                                </div>
                                <div class="col-md-6">
                                    <ul class="list">
                                        <li><a href="#" title="Help Desk">Blog</a></li>
                                        <li><a href="#" title="Support">Support</a></li>
                                    </ul>
                                </div>
                            </div>

                        </div>
                    </div>

                    <div class="col-sm-6 col-md-6 col-lg-4">
                        <div class="footer-item">
                            <div class="footer-title">
                                Get a Newslatter
                            </div>

                            <p>Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.</p>

                        </div>
                    </div>

                </div>

            </div>
        </div>
        <div class="fcopy">
            <div class="container">
                <div class="row">
                    <div class="col-sm-12 col-md-12 col-lg-12">
                        <p class="mt-3 text-center">Copyright 2020 Subsco HTML Template – All rights reserved.</p>
                    </div>
                </div>
            </div>
        </div>

    </div>
    <!-- 路由占位符 -->
    <router-view></router-view>
 </div>
</template>

<script src="../../public/js/vendor/modernizr.min.js"></script>
<!-- JS VENDOR -->
<script src="../../public/js/vendor/jquery.min.js"></script>
<script src="../../public/js/vendor/bootstrap.min.js"></script>
<script src="../../public/js/vendor/owl.carousel.js"></script>
<script src="../../public/js/vendor/jquery.magnific-popup.min.js"></script>
<!-- SENDMAIL -->
<script src="../../public/js/vendor/validator.min.js"></script>
<script src="../../public/js/vendor/form-scripts.js"></script>
<script src="../../public/js/script.js"></script>

<script>
import search from '../components/search.vue'
export default {
  components:{
    search
  },
  data() {
    return {
      input: ''
    };
  },

  methods: {
    trans () {
      setTimeout(() => {
        this.$router.push('/about' + '?query=' + this.input)
      }, 200)
    }
  }
}
</script>

<style src="../../public/css/vendor/bootstrap.min.css"></style>
<style src="../../public/css/vendor/owl.carousel.min.css"></style>
<style src="../../public/css/vendor/owl.theme.default.min.css"></style>
<style src="../../public/css/vendor/magnific-popup.css"></style>
<style src="../../public/css/vendor/animate.min.css"></style>
<style src="../../public/css/fontawesome.css"></style>
<style src="../../public/css/brands.css"></style>
<style src="../../public/css/solid.css"></style>
<style src="../../public/css/style.css"></style>
