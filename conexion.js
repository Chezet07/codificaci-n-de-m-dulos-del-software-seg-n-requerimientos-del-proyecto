let msqly = requiere("mysql");

let conexion=msqly.createConnection({
    host: "localhost",
    database: "Asistente",
    user: "root",
    password: ""
});

conexion.connect(function(error){
    if(error){
        throw error;
    
    }
    else{
        console.log("Se ha conectado correctamente");
    }
});

conexion.end();