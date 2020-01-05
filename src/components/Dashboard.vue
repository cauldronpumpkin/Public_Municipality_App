<template>
    <div>
        123
    </div>
</template>

<script>
//import axios from 'axios';
import router from '../router';

export default {
    name: "Dashboard",
    data: () => ({

    }),
    created() {
        this.checkLoggedIn();
    },
    methods: {
        checkLoggedIn() {
          this.$session.start();
          if (!this.$session.has('check')) {
            router.push("/auth");
          }
        }
    }
}
</script>