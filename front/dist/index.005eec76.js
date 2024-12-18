// Almacenamiento de productos (simulando una base de datos local)
let products = [];
function showAlert(message, type) {
    const alertBox = document.getElementById('alertMessage');
    alertBox.textContent = message;
    alertBox.className = `alert ${type}`;
    alertBox.style.display = 'block';
    setTimeout(()=>alertBox.style.display = 'none', 3000);
}
// Función para añadir un producto
function addProduct() {
    const id = document.getElementById('productId').value.trim();
    const name = document.getElementById('productName').value.trim();
    const price = parseFloat(document.getElementById('productPrice').value.trim());
    const stock = parseInt(document.getElementById('productStock').value.trim());
    if (!id || !name || isNaN(price) || isNaN(stock)) {
        showAlert('Por favor, rellene todos los campos correctamente.', 'error');
        return;
    }
    const existingProduct = products.find((product)=>product.id === id);
    if (existingProduct) {
        showAlert('El producto con este ID ya existe.', 'error');
        return;
    }
    const newProduct = {
        id,
        name,
        price,
        stock
    };
    products.push(newProduct);
    updateProductTable();
    showAlert("Producto a\xf1adido exitosamente.", 'success');
    clearForm();
}
// Función para actualizar la tabla de productos
function updateProductTable() {
    const tableBody = document.querySelector('#productTable tbody');
    tableBody.innerHTML = ''; // Limpiamos la tabla
    products.forEach((product)=>{
        const row = document.createElement('tr');
        row.innerHTML = `
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>\u{20AC}${product.price.toFixed(2)}</td>
            <td>${product.stock}</td>
            <td>
                <button onclick="updateProduct('${product.id}')">Actualizar</button>
                <button onclick="deleteProduct('${product.id}')">Eliminar</button>
            </td>
        `;
        tableBody.appendChild(row);
    });
}
// Función para actualizar stock o precio de un producto
function updateProduct(productId) {
    const product = products.find((product)=>product.id === productId);
    const newStock = prompt(`Actualizar stock para ${product.name}:`, product.stock);
    const newPrice = prompt(`Actualizar precio para ${product.name}:`, product.price);
    if (newStock !== null && !isNaN(newStock)) product.stock = parseInt(newStock);
    if (newPrice !== null && !isNaN(newPrice)) product.price = parseFloat(newPrice);
    updateProductTable();
    showAlert('Producto actualizado correctamente.', 'success');
}
// Función para eliminar un producto
function deleteProduct(productId) {
    const productIndex = products.findIndex((product)=>product.id === productId);
    if (productIndex > -1) {
        products.splice(productIndex, 1);
        updateProductTable();
        showAlert('Producto eliminado correctamente.', 'success');
    }
}
// Limpiar formulario
function clearForm() {
    document.getElementById('productId').value = '';
    document.getElementById('productName').value = '';
    document.getElementById('productPrice').value = '';
    document.getElementById('productStock').value = '';
}

//# sourceMappingURL=index.005eec76.js.map
