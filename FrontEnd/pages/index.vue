<template>
<v-card class="mx-auto" max-width="500">
    <v-toolbar color="pink" dark>
        <v-app-bar-nav-icon></v-app-bar-nav-icon>
        <v-toolbar-title>大学図鑑</v-toolbar-title>
        <v-spacer></v-spacer>
        <v-btn icon>
            <v-icon>mdi-magnify</v-icon>
        </v-btn>
        <v-btn icon>
            <v-icon>mdi-checkbox-marked-circle</v-icon>
        </v-btn>
    </v-toolbar>

    <v-list v-for="university in universities"   :key="university.id"  cols="12"  >
        <v-list-item-group>
            <v-list-item>
                <v-list-item-action>
                    <v-radio  :key="university.id" :value="university"  @click="select(university)"></v-radio>
                </v-list-item-action>
                <v-list-item-content>
                    <v-list-item-title>{{university.id}}</v-list-item-title>
                </v-list-item-content>
                <v-list-item-content>
                    <v-list-item-title>{{university.name}}</v-list-item-title>
                </v-list-item-content>
                <v-list-item-content>
                    <v-list-item-title>{{university.furikana}}</v-list-item-title>
                </v-list-item-content>
                <v-list-item-action>
                    <v-btn @click="deleteUniversity(university.id)">
                        <v-icon>
                            mdi-backspace
                        </v-icon>
                    </v-btn>
                </v-list-item-action>
            </v-list-item>
        </v-list-item-group>
    </v-list>
    <v-col cols="12" class="d-flex" v-if="!selectUniversity">
    大学追加
        <v-list-item-content>
            <v-text-field v-model="universityInfo.name" label="大学名" required></v-text-field>
            <v-text-field v-model=" universityInfo.furikana" label="フリガナ" required></v-text-field>
        </v-list-item-content>
        <v-list-item-action>
            <v-btn @click.stop="addUniversity(universityInfo)">
                <v-icon>
                    mdi-plus-circle
                </v-icon>
            </v-btn>
        </v-list-item-action>
    </v-col>
    <v-col cols="12" class="d-flex" v-if="selectUniversity">
    大学編集
        <v-list-item-content>
            <v-text-field v-model="selectUniversity.name" required></v-text-field>
            <v-text-field v-model=" selectUniversity.furikana" required></v-text-field>
        </v-list-item-content>
        <v-list-item-action>
            <v-btn @click="editUniversity(selectUniversity)">
                <v-icon>
                    mdi-plus-circle
                </v-icon>
            </v-btn>
        </v-list-item-action>
    </v-col>
</v-card>
</template>

<script>
import axios from 'axios';
export default {
    name: 'IndexPage',
    data: () => ({
        mountains: [],
        posts: [],
        universities: [],
        universityInfo: {},
        isCkecked:false,
        selectUniversity:null,
    }),
    // eslint-disable-next-line object-shorthand
    created: async function () {
        const university = await axios.get('api/')
            // eslint-disable-next-line no-return-assign
            .then((response) => this.posts = response)
        this.universities = university.data;
    },
    methods: {

        async addUniversity(addUniversityInfo) {
            const universityInfoObject={
                name: addUniversityInfo.name,
                furikana: addUniversityInfo.furikana
            };

        await axios.post('api/add',universityInfoObject,
        {headers:{ 
            'Content-Type': 'application/json'}
        })
                .then(function (response) {
                    console.log(response.data);
                })
        const university = await axios.get('api/')
            // eslint-disable-next-line no-return-assign
            .then((response) => this.posts = response)
        this.universities = university.data;
        this.universityInfo={};
        },
        async deleteUniversity(universityId){
            await axios.delete('api/'+universityId)
            // eslint-disable-next-line no-return-assign
            .then((response) => this.posts = response);

            this.universities= this.universities.filter(university=>university.id!==universityId);
        },

        select(university){
            this.selectUniversity=university;
        },
        async editUniversity(editUniversityInfo) {
            const universityInfoObject={
                id:editUniversityInfo.id,
                name: editUniversityInfo.name,
                furikana: editUniversityInfo.furikana
            };

        await axios.put('api/',universityInfoObject,
        {headers:{ 
            'Content-Type': 'application/json'}
        })
                .then(function (response) {
                    console.log(response.data);
                })
        const university = await axios.get('api/')
            // eslint-disable-next-line no-return-assign
            .then((response) => this.posts = response)
        this.universities = university.data;
        this.editUniversityInfo=null;
        },
    }
}
</script>
