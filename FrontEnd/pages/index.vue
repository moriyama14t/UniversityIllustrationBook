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

    <v-list v-for="university in universities" :key="university.id" cols="12">
        <v-list-item-group>
            <v-list-item>
                <v-list-item-action>
                    <v-checkbox :input-value=university.done @click="done(university.id)"></v-checkbox>
                </v-list-item-action>
                <v-list-item-content>
                    <v-list-item-title>{{university.id}}</v-list-item-title>
                </v-list-item-content>
                <v-list-item-content>
                    <v-list-item-title>{{university.name}}</v-list-item-title>
                </v-list-item-content>
                <v-list-item-content>
                    <v-list-item-title>{{university.name}}</v-list-item-title>
                </v-list-item-content>
                <v-list-item-action>
                    <v-btn @click="deleteTask(university.id)">
                        <v-icon>
                            mdi-backspace
                        </v-icon>
                    </v-btn>
                </v-list-item-action>
            </v-list-item>
        </v-list-item-group>
    </v-list>
    <v-col cols="12" class="d-flex">
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
    }),
    // eslint-disable-next-line object-shorthand
    created: async function () {
        const a = await axios.get('api/')
            // eslint-disable-next-line no-return-assign
            .then((response) => this.posts = response)
        this.universities = a.data;
    },
    methods: {

        async addUniversity(addUniversityInfo) {
            console.log(addUniversityInfo);
            console.log({
                name: addUniversityInfo.name,
                furikana: addUniversityInfo.furikana
            });

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

                        const a = await axios.get('api/')
            // eslint-disable-next-line no-return-assign
            .then((response) => this.posts = response)
        this.universities = a.data;
        this.universityInfo={};
        },
    }
}
</script>
