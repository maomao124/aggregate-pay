<template>
  <div class="navbar">
    <breadcrumb
      id="breadcrumb-container"
      class="breadcrumb-container"
    />
 
  </div>
</template>

<script lang="ts">
import { Component, Vue } from 'vue-property-decorator'
import { AppModule } from '@/store/modules/app'
import { UserModule } from '@/store/modules/user'
import Breadcrumb from '@/components/Breadcrumb/index.vue'


@Component({
  name: 'Navbar',
  components: {
    Breadcrumb
  }
})
export default class extends Vue {
 



}
</script>

<style lang="scss" scoped>
.navbar {
  height: 60px;
  padding: 10px 0 0 10px;
  box-sizing: border-box;
  background: #f3f6fb;
  font-size: 20px;
  margin-top: 50px;
  width: 1200px;
  margin: 0 auto;
  margin-top: 60px;

  .breadcrumb-container {
    float: left;
  }

}
</style>
