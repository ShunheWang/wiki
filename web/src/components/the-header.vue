<template>
    <a-layout-header class="header">
        <div class="logo" />
        <a-menu theme="dark" mode="horizontal" :style="{ lineHeight: '64px' }">
            <a-menu-item key="home">
                <router-link to="/">home</router-link>
            </a-menu-item>
            <a-menu-item key="2">
                <router-link to="/admin/ebook">ebook manage</router-link>
            </a-menu-item>
            <a-menu-item key="3">
                <router-link to="/about">about me</router-link>
                </a-menu-item>
        </a-menu>
    </a-layout-header>
</template>

<script lang="ts">
    import { defineComponent } from 'vue';

    export default defineComponent({
        name: 'the-header'
    });
</script>