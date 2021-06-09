<template>
  <a-layout>
    <a-layout-sider width="200" style="background: #fff">
      <a-menu
              mode="inline"
              :style="{ height: '100%', borderRight: 0 }"
      >
        <a-sub-menu key="sub1">
          <template #title>
              <span>
                <user-outlined />
                subnav 1
              </span>
          </template>
          <a-menu-item key="1">option1</a-menu-item>
          <a-menu-item key="2">option2</a-menu-item>
          <a-menu-item key="3">option3</a-menu-item>
          <a-menu-item key="4">option4</a-menu-item>
        </a-sub-menu>
        <a-sub-menu key="sub2">
          <template #title>
              <span>
                <laptop-outlined />
                subnav 2
              </span>
          </template>
          <a-menu-item key="5">option5</a-menu-item>
          <a-menu-item key="6">option6</a-menu-item>
          <a-menu-item key="7">option7</a-menu-item>
          <a-menu-item key="8">option8</a-menu-item>
        </a-sub-menu>
        <a-sub-menu key="sub3">
          <template #title>
              <span>
                <notification-outlined />
                subnav 3
              </span>
          </template>
          <a-menu-item key="9">option9</a-menu-item>
          <a-menu-item key="10">option10</a-menu-item>
          <a-menu-item key="11">option11</a-menu-item>
          <a-menu-item key="12">option12</a-menu-item>
        </a-sub-menu>
      </a-menu>
    </a-layout-sider>
    <a-layout-content :style="{ background: '#fff', padding: '24px', margin: 0, minHeight: '280px' }">
      <pre>{{ebooks}}</pre>
      <pre>{{ebooks2}}</pre>
    </a-layout-content>
  </a-layout>
</template>

<script lang="ts">
import { defineComponent, onMounted, ref, reactive, toRef } from 'vue';
import axios from 'axios';

export default defineComponent({
  name: 'Home',
  setup() {
    console.log("setup");
    // 1
    const ebooks = ref(); // ref -> 响应式数据，用于将后端发来的数据实时的渲染到页面上
    // 2
    const ebooks1 = reactive({books : []});
    // all init functions should be in it
    onMounted(() => {
      console.log("onMount()");
      axios.get("http://localhost:8881/list?name=Spring").then((response) => {
        const data = response.data;
        // 1
        ebooks.value = data.content;
        // 2
        ebooks1.books = data.content;
        // console.log(ebooks);
      });
    });

    return {
      // 1
      ebooks,
      // 2
      ebooks2 : toRef(ebooks1,"books")
    }
  }
});
</script>
