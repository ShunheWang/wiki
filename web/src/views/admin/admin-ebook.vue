<template>
    <a-layout>
        <a-layout-content :style="{ background: '#fff', padding: '24px', margin: 0, minHeight: '280px' }">
            <a-table :columns="columns" :row-key="record => record.id" :data-source="ebooks" :pagination="pagination" :loading="loading" @change="handleTableChange">
                <template #cover="{text:cover}">
                    <img v-if="cover" :src="cover" alt="avatar" />
                </template>
                <template v-slot:action="{text,record}">
                    <a-space size="small">
                        <a-button type="primary">
                            modify
                        </a-button>
                        <a-button type="danger">
                            delete
                        </a-button>
                    </a-space>
                </template>
            </a-table>
        </a-layout-content>
    </a-layout>
</template>

<script lang="ts">
    import { defineComponent, onMounted, ref} from 'vue';
    import axios from 'axios';
    import _default from "ant-design-vue/es/vc-pagination/Pager";

    export default defineComponent({
        name: 'AdminEbook',
        setup() {
            const ebooks = ref();
            const pagination = ref({
                current: 1,
                pageSize: 2,
                total: 0
            });
            const loading = ref(false);
            const columns = [
                {
                    title: '封面',
                    dataIndex: 'cover',
                    slots: {customRender: 'cover'}
                },
                {
                    title: '名称',
                    dataIndex: 'name'
                },
                {
                    title: '分类一',
                    key: 'category1Id',
                    dataIndex: 'category1id',
                },
                {
                    title: '分类二',
                    dataIndex: 'category2id',
                },
                {
                    title: '文档数',
                    dataIndex: 'docCount',
                },
                {
                    title: '阅读数',
                    dataIndex: 'viewCount',
                },
                {
                    title: '点赞数',
                    dataIndex: 'voteCount',
                },
                {
                    title: 'Action',
                    key: 'action',
                    slots: {customRender: 'action'}
                },
            ];

            /**
             * data query
             * @param params
             */
            const handleQuery = (params: any) => {
              loading.value = true;
              axios.get("/ebook/list", params).then((response) => {
                 loading.value = false;
                 const data = response.data;
                 ebooks.value = data.content;

                 // 重置分页按钮
                  pagination.value.current = params.page;
              });
            };

            /**
             * 表格点击页码时触发
             */
            const handleTableChange = (pagination: any) => {
              console.log("page params -> " + pagination);
              handleQuery({
                  page: pagination.current,
                  size: pagination.pageSize
              });
            };

            onMounted(() => {
               handleQuery({});
            });

            return {
                ebooks,
                pagination,
                columns,
                loading,
                handleTableChange
            }
        }

    });
</script>