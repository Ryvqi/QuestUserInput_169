package com.example.userinput

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun UserInput(){
    var nama by remember {
        mutableStateOf("")
    }

    var email by remember {
        mutableStateOf("")
    }

    var noHP by remember {
        mutableStateOf("")
    }

    var alamat by remember {
        mutableStateOf("")
    }

    var datanama by remember {
        mutableStateOf("")
    }

    var dataemail by remember {
        mutableStateOf("")
    }
    var datanoHP by remember {
        mutableStateOf("")
    }
    var dataalamat by remember {
        mutableStateOf("")
    }

    var kelaminadadua by remember { mutableStateOf("") }
    var datakelaminadadua by remember { mutableStateOf("") }

    val dataJK = listOf("Laki", "Perempuan")

    Column(modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Biodata", fontWeight = FontWeight.Bold,
            fontSize = 28.sp)
        Spacer(modifier = Modifier.padding(20.dp))
        TextField(modifier = Modifier.fillMaxWidth().padding(5.dp),
            value = nama,
            onValueChange = {nama = it},
            label = { Text("Nama") },
            placeholder = { Text("Masukan Nama Anda") }
        )

        Row(modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically) {
            dataJK.forEach{
                selectedJK ->
                Row {
                    RadioButton(selected = kelaminadadua == selectedJK,
                        onClick = {kelaminadadua = selectedJK})
                }
            }
        }

        TextField(modifier = Modifier.fillMaxWidth().padding(5.dp),
            value = email,
            onValueChange = {email = it},
            label = { Text("Email") },
            placeholder = { Text("Masukan Email Anda") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        TextField(modifier = Modifier.fillMaxWidth().padding(5.dp),
            value = noHP,
            onValueChange = {noHP = it},
            label = { Text("NoHP") },
            placeholder = { Text("Masukan NoHP Anda") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        TextField(modifier = Modifier.fillMaxWidth().padding(5.dp),
            value = alamat,
            onValueChange = {alamat = it},
            label = { Text("Alamat") },
            placeholder = { Text("Masukan Alamat Anda") }
        )
        Button(modifier = Modifier.padding(vertical = 10.dp),onClick = {
            datanama = nama
            datakelaminadadua = kelaminadadua
            dataemail = email
            datanoHP = noHP
            dataalamat = alamat}) {
            Text("Pencet")
        }
        Card(modifier = Modifier.fillMaxWidth() .padding(16.dp)) {
            Column {
                TampilData(judul = "Nama", isinya = datanama)

                TampilData(judul = "Jenis Kelamin", isinya = datakelaminadadua)

                TampilData(judul = "Email", isinya = dataemail)

                TampilData(judul = "NoHP", isinya = datanoHP)

                TampilData(judul = "Alamat", isinya = dataalamat)
            }
        }
    }
}

@Composable
fun TampilData(judul:String, isinya:String){
    Row(modifier = Modifier.fillMaxWidth()
        .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween) {
        Text(judul, modifier = Modifier.weight(0.8f))
        Text(":", modifier = Modifier.weight(0.2f))
        Text(isinya, modifier = Modifier.weight(2f))
    }
}
