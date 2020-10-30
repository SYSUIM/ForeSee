<template>
    <div id="home" class="banner">
      <!-- <div class="owl-carousel owl-theme full-screen"> -->
        <div class="item">
            <div class="overlay-bg"></div>
            <div class="container d-flex align-items-center h-center">
                <div class="wrap-caption">
                    <h1 class="caption-heading text-white">Engineering your dreams with us</h1>
                    <input type="text" class="search keyword" placeholder="Search Company" v-model="input" @keyup.enter="trans" />
                    <button class="btn btn-primary" type="button" @click="trans">Search</button>
                    <!--a href="#" class="btn btn-secondary">Contact Us</a-->
                </div>
              </div>
        </div>
      </div>

    <!-- </div> -->
</template>

<script>
export default {
  data () {
    return {
      input: ''
    }
  },
  methods: {
    trans () {
      setTimeout(() => {
        this.$router.push('/retrieval' + '?query=' + this.input)
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
<style>
  .banner .inner{
  position: absolute;
  top: 100;
  left: 0;
  right: 0;
  background-color: (0,0,0,0.5);
}
</style>