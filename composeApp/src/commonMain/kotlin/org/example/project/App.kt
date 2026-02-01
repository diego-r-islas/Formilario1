package org.example.project

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.text.input.KeyboardType



@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun App(){

    var nombre by remember { mutableStateOf("") }
    var matricula by remember { mutableStateOf("") }
    var asignatura by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }
    var hora by remember { mutableStateOf("") }
    var fecha by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(text = "Formulario de datos",
                style=MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.primary)

        TextField(
            value = nombre,
            onValueChange = { nombre=it
            },
            label = { Text("Nombre: ")},
            modifier = Modifier.fillMaxWidth(),
            shape = MaterialTheme.shapes.medium
        )

        val asignaturas = listOf("Desarrollo de apps móviles",
            "Diseño de software", "Cálculo", "Apps web", "Estructura de datos", "Defensa contra las artes oscuras")

        TextField(
            value = matricula,
            onValueChange = {matricula=it},
            label = { Text("Matrícula: ") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth(),
            shape = MaterialTheme.shapes.medium
        )

        ExposedDropdownMenuBox(expanded=expanded,
            onExpandedChange = {expanded = !expanded }){
            TextField(
                value=asignatura,
                onValueChange = {},
                readOnly=true,
                label = {Text("Asignatura")},
                shape = MaterialTheme.shapes.medium,
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
                },
                modifier= Modifier.fillMaxWidth()
                    .menuAnchor()
            )
            ExposedDropdownMenu(expanded=expanded,
                onDismissRequest = {expanded = false}){
                asignaturas.forEach { opcion -> DropdownMenuItem(
                    text = {Text(opcion)},
                    onClick = {asignatura = opcion
                    expanded = false
                    }
                ) }
            }
        }

        TextField(
            value = fecha,
            onValueChange = {
                if(it.length <= 10){
                    fecha = when (it.length){
                        2, 5 ->"$it/"
                        else -> it
                    }
                }
            },
            label = { Text("Fecha de entrega: ") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth(),
            shape = MaterialTheme.shapes.medium
        )

        TextField(
            value = hora,
            onValueChange = {
                if (it.length <=5){
                    hora = when (it.length){2->"$it:" else ->it}
                }
            },
            label = { Text("Hora que se imparte: ") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth(),
            shape = MaterialTheme.shapes.medium
        )
    }


    var contador by remember { mutableStateOf(0) }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center // 🔴 CENTRA TODO
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Registro exitoso: $contador")

            Button(onClick = { contador++ },
                ) {
                Text("Aceptar datos")
            }
        }
    }
    // Column organiza elementos en forma vertical
    Column(
        modifier = Modifier
            .fillMaxSize()     // Ocupa toda la pantalla
            .padding(16.dp),  // Margen interno

        // Alineación horizontal


        // Alineación vertical
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {

    }
}