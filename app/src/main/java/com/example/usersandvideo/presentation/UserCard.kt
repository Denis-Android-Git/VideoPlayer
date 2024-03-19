package com.example.usersandvideo.presentation

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.domain.model.User

@Composable
fun UserCard(
    user: User
) {
    Card(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.padding(3.dp)
        ) {
            Text(
                text = "Name:",
                modifier = Modifier.padding(3.dp),
                fontWeight = FontWeight.Bold
            )
            Text(
                text = user.name,
                modifier = Modifier.padding(3.dp)
            )
        }
        Row(
            modifier = Modifier.padding(3.dp)
        ) {
            Text(
                text = "Username:",
                modifier = Modifier.padding(3.dp),
                fontWeight = FontWeight.Bold
            )
            Text(
                text = user.username,
                modifier = Modifier.padding(3.dp)
            )
        }
        Row(
            modifier = Modifier.padding(3.dp)
        ) {
            Text(
                text = "Email:",
                modifier = Modifier.padding(3.dp),
                fontWeight = FontWeight.Bold
            )
            Text(
                text = user.email,
                modifier = Modifier.padding(3.dp)
            )
        }
        Row(
            modifier = Modifier.padding(3.dp)
        ) {
            Text(
                text = "Address:",
                modifier = Modifier.padding(3.dp),
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "${user.address.zipcode}, ${user.address.city}, ${user.address.street}, ${user.address.suite}",
                modifier = Modifier.padding(3.dp)
            )
        }
        Row(
            modifier = Modifier.padding(3.dp)
        ) {
            Text(
                text = "Phone:",
                modifier = Modifier.padding(3.dp),
                fontWeight = FontWeight.Bold
            )
            Text(
                text = user.phone,
                modifier = Modifier.padding(3.dp)
            )
        }
        Row(
            modifier = Modifier.padding(3.dp)
        ) {
            Text(
                text = "Website:",
                modifier = Modifier.padding(3.dp),
                fontWeight = FontWeight.Bold
            )
            Text(
                text = user.website,
                modifier = Modifier.padding(3.dp)
            )
        }
        Row(
            modifier = Modifier.padding(3.dp)
        ) {
            Text(
                text = "Company:",
                modifier = Modifier.padding(3.dp),
                fontWeight = FontWeight.Bold
            )
            Text(
                text = user.company.name,
                modifier = Modifier.padding(3.dp)
            )
        }
        Row(
            modifier = Modifier.padding(3.dp)
        ) {
            Text(
                text = "Business",
                modifier = Modifier.padding(3.dp),
                fontWeight = FontWeight.Bold
            )
            Text(
                text = user.company.bs,
                modifier = Modifier.padding(3.dp)
            )
        }
        Row(
            modifier = Modifier.padding(3.dp)
        ) {
            Text(
                text = "Catch Phrase:",
                modifier = Modifier.padding(3.dp),
                fontWeight = FontWeight.Bold
            )
            Text(
                text = user.company.catchPhrase,
                modifier = Modifier.padding(3.dp)
            )
        }
        Row(
            modifier = Modifier.padding(3.dp)
        ) {
            Text(
                text = "Coordinates:",
                modifier = Modifier.padding(3.dp),
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "${user.address.geo.lat}, ${user.address.geo.lng}",
                modifier = Modifier.padding(3.dp)
            )
        }
    }
}