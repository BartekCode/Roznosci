function creatNextInputs(){
    let doorWindowDiv = document.getElementById("construction-container");
    let nextInputContainer = document.createElement("div");
    let nextInputLabel = document.createElement("spam");
    nextInputLabel.innerText = "Drzwi / Okno";

    let widthInput = document.createElement("input");
    widthInput.placeholder = "Szerokość";
    widthInput.name = "width";
    let heightInput = document.createElement("input");
    heightInput.placeholder = "Wysokość";
    heightInput.name = "height";

    nextInputContainer.append(nextInputLabel);
    nextInputContainer.append(widthInput);
    nextInputContainer.append(heightInput);
    doorWindowDiv.prepend(nextInputContainer);
}

function getConstructionElementsNumber() {
    document.getElementById("construction-elements");
    return constructionElementInput.value;

}

function incrementCutElements() {
    let constructionElementsInput = document.getElementById("construction-elements");
    constructionElementsInput.value++;
}

function addDoorOrWindowInput() {
    createNextInputs();
    incrementCutElements();
}

function registerAddButton() {
    let addButton = document.getElementById("add-button");
    addButton.onclick = () => addDoorOrWindowInput();
}
//Kod JavaScript odpowiada głównie za obsługę przycisku "Dodaj okno lub drzwi" w formularzu.