package com.example.micromanager2_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.amazonaws.amplify.generated.graphql.ListMmSchedulesQuery
import com.amazonaws.mobile.config.AWSConfiguration
import com.amazonaws.mobileconnectors.appsync.AWSAppSyncClient
import com.amazonaws.mobileconnectors.appsync.fetcher.AppSyncResponseFetchers
import com.apollographql.apollo.GraphQLCall
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.exception.ApolloException

class MainActivity : AppCompatActivity() {

    private lateinit var awsAppSyncClient: AWSAppSyncClient
    private val mmScheduleCallback: GraphQLCall.Callback<ListMmSchedulesQuery.Data> =
            object : GraphQLCall.Callback<ListMmSchedulesQuery.Data>() {
                override fun onFailure(e: ApolloException) {
                    TODO("Not yet implemented")
                }

                override fun onResponse(response: Response<ListMmSchedulesQuery.Data>) {
                    TODO("Not yet implemented")
                }

            }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        awsAppSyncClient = AWSAppSyncClient.builder()
                .context(applicationContext)
                .awsConfiguration(AWSConfiguration(applicationContext))
                .build()

        awsAppSyncClient.query(ListMmSchedulesQuery.builder().build())
                .responseFetcher(AppSyncResponseFetchers.CACHE_AND_NETWORK)
                .enqueue(mmScheduleCallback)
    }
}
