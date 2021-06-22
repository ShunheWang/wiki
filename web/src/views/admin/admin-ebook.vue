<template>
    <a-layout>
        <a-layout-content :style="{ background: '#fff', padding: '24px', margin: 0, minHeight: '280px' }">
            <a-list item-layout="vertical" size="large" :data-source="ebooks" :grid="{ gutter: 20, column:3 }">
                <div class="about">
                    ebook management
                </div>
            </a-list>
        </a-layout-content>
    </a-layout>
</template>