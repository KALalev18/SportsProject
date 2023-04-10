const intervalTime = 2000;
const photoContainer = document.getElementById("photo-container");
const photos = photoContainer.getElementsByTagName("img");
let currentPhotoIndex = 0;
function changePhoto() {
    photos[currentPhotoIndex].style.display = "none";
    currentPhotoIndex++;
    if (currentPhotoIndex >= photos.length) {
        currentPhotoIndex = 0;
    }
    photos[currentPhotoIndex].style.display = "block";
}
setInterval(changePhoto, intervalTime);