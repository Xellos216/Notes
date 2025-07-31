let isEditMode = false;
        let editingMemberId = null;

        import {
            initializeApp
        } from "https://www.gstatic.com/firebasejs/9.22.0/firebase-app.js";

        import {
            getFirestore,
            collection,
            addDoc,
            getDocs,
            getDoc,
            doc,
            updateDoc,
            deleteDoc
        } from "https://www.gstatic.com/firebasejs/9.22.0/firebase-firestore.js";

        import {
            getStorage,
            ref,
            uploadBytes,
            getDownloadURL
        } from "https://www.gstatic.com/firebasejs/9.22.0/firebase-storage.js";

        import {
            getAuth, signInAnonymously
        } from "https://www.gstatic.com/firebasejs/9.22.0/firebase-auth.js";


        const firebaseConfig = {
            apiKey: "AIzaSyCRjeXLdZxtdtav-1f1Ogg0-8eUTYJRlzU",
            authDomain: "sparta-162c6.firebaseapp.com",
            projectId: "sparta-162c6",
            storageBucket: "sparta-162c6.firebasestorage.app",
            messagingSenderId: "338083360334",
            appId: "1:338083360334:web:ef8c1a44db570c3b849d1f",
            measurementId: "G-GBNQSKJGGK"
        };


        const app = initializeApp(firebaseConfig);
        const auth = getAuth(app);
        const db = getFirestore(app);

        signInAnonymously(auth)
            .then(() => {
                console.log("✅ 익명 로그인 완료");
            })
            .catch((error) => {
                console.error("❌ 익명 로그인 실패:", error.code, error.message);
            });


        async function checkPassword(inputPw) {
            const docRef = doc(db, "settings", "editkey");
            const docSnap = await getDoc(docRef);

            if (docSnap.exists()) {
                const realPw = docSnap.data().value;
                return inputPw === realPw;
            } else {
                alert("인증 설정이 없습니다.");
                console.warn("[Firestore] settings/editkey 문서 없음");
                return false;
            }
        }

        let teamMembers = [];

        const DEFAULT_IMAGE_URL = "default.png";

        async function loadTeamMembers() {
            const querySnapshot = await getDocs(collection(db, "Team_8"));
            teamMembers = [];
            querySnapshot.forEach((docSnap) => {
                const data = docSnap.data();
                teamMembers.push({
                    id: docSnap.id,
                    photo: data.image || "default.png",
                    name: data.name || "이름 없음",
                    comment: data.comment || "",
                    github: data.github || null,
                    mbti: data.mbti || "정보 없음",
                    intro: data.intro || "소개 없음",
                    hobby: data.hobby || "취미 없음"
                });
            });
            renderCards();
        }

        function renderCards() {
            if (teamMembers.length === 0) {
                $("#cardArea").html("<p>팀원 정보가 없습니다.</p>");
                return;
            }
            let html = "";
            teamMembers.forEach((member, idx) => {
                html += `
        <div class="card" data-index="${idx}">
          <img src="${member.photo}" class="card-img-top" onerror="this.onerror=null;this.src='default.png';" />
          <div class="card-body text-center">
            <h5 class="card-title">${member.name}</h5>
            <p class="card-text">${member.comment}</p>
          </div>
        </div>
      `;
            });
            $("#cardArea").html(html);
            $(".card").click(function () {
                const index = $(this).data("index");
                showModal(teamMembers[index]);
            });
        }

        function showModal(member) {
            const githubId = (member.github || "").trim();
            const githubLink = githubId.startsWith("http")
                ? githubId
                : `https://github.com/${githubId}`;
            const modalHtml = `
      <div class="card-modal-backdrop">
        <div class="modal-content-custom">
          <button id="closeModal" aria-label="닫기">&times;</button>
          <button id="editBtn" aria-label="Edit" class="edit-icon-btn">✏️</button>
          <img src="${member.photo}" alt="${member.name}" onerror="this.onerror=null;this.src='default.png';" />
          <h3>${member.name}</h3>
          <p><strong>MBTI:</strong> ${member.mbti}</p>
          <p><strong>자기소개:</strong> ${member.intro}</p>
          <p><strong>취미:</strong> ${member.hobby}</p>
          <a href="${githubLink}" target="_blank" rel="noopener noreferrer">Github</a>
          <div class="mt-3">
          </div>
        </div>
      </div>
    `;
            $("body").append(modalHtml);
            $("#closeModal").click(() => $(".card-modal-backdrop").remove());
            $(".card-modal-backdrop").click(function (e) {
                if (e.target === this) $(this).remove();
            });

            $("#editBtn").click(async () => {
                let retry = 0;
                while (retry < 3) {
                    const pw = prompt("인증번호를 입력하세요!");
                    if (pw === null) return;
                    const isCorrect = await checkPassword(pw);
                    if (isCorrect) break;
                    alert("인증번호가 맞지 않습니다.");
                    retry++;
                }
                if (retry === 3) return;

                isEditMode = true;
                editingMemberId = member.id;

                $("#name").val(member.name);
                $("#comment").val(member.comment);
                $("#github").val(member.github);
                $("#mbti").val(member.mbti);
                $("#intro").val(member.intro);
                $("#hobby").val(member.hobby);
                $("#fileName").text("수정 시 새 사진 선택");
                $("#submitBtn").text("수정");
                $("#deleteInForm").remove();

                $("<button>")
                    .attr("id", "deleteInForm")
                    .addClass("btn btn-danger mt-3 w-100")
                    .text("삭제")
                    .insertAfter("#submitBtn")
                    .click(async () => {
                        const confirmDelete = confirm("정말 삭제하시겠습니까?");
                        if (!confirmDelete) return;
                        await deleteDoc(doc(db, "Team_8", editingMemberId));
                        alert("삭제되었습니다!");
                        $("#registerModal").fadeOut();
                        loadTeamMembers();
                    });

                $(".card-modal-backdrop").fadeOut(() => {
                    $(".card-modal-backdrop").remove();
                    $("#registerModal").fadeIn();
                });
            });
        }


        $(document).ready(function () {
            $("#toggleFormBtn").click(async () => {
                let retry = 0;
                while (retry < 3) {
                    const pw = prompt("인증번호를 입력하세요!");
                    if (pw === null) return;
                    const isCorrect = await checkPassword(pw);
                    if (isCorrect) break;
                    alert("인증번호가 맞지 않습니다.");
                    retry++;
                }
                if (retry === 3) return;

                isEditMode = false;
                editingMemberId = null;
                $("#name, #comment, #github, #mbti, #intro, #hobby").val("");
                $("#imageFile").val("");
                $("#fileName").text("사진을 올려주세요!");
                $("#submitBtn").text("등록하기");
                $("#deleteInForm").remove();
                $("#registerModal").fadeIn();
            });

            $("#closeRegisterModal").click(() => {
                $("#registerModal").fadeOut();
            });

            $("#registerModal").click(function (e) {
                if (e.target === this) {
                    $(this).fadeOut();
                }
            });

            $("#submitBtn").off("click").on("click", async function () {
                const requiredFields = [
                    { id: "name", label: "이름" },
                    { id: "comment", label: "한마디" },
                    { id: "mbti", label: "MBTI" },
                    { id: "intro", label: "자기소개" },
                    { id: "hobby", label: "취미" }
                ];

                for (const field of requiredFields) {
                    if (!$(`#${field.id}`).val().trim()) {
                        alert(`${field.label}을(를) 입력해주세요!`);
                        return;
                    }
                }
                const fileInput = document.getElementById("imageFile");
                const file = fileInput.files[0];
                let imageUrl = "";
                if (file) {
                    const storage = getStorage();
                    const storageRef = ref(storage, `team_images/${Date.now()}_${file.name}`);
                    const snapshot = await uploadBytes(storageRef, file);
                    imageUrl = await getDownloadURL(snapshot.ref);
                }
                const data = {
                    image: imageUrl || (isEditMode
                        ? teamMembers.find(m => m.id === editingMemberId)?.photo || DEFAULT_IMAGE_URL
                        : DEFAULT_IMAGE_URL),
                    name: $("#name").val(),
                    comment: $("#comment").val(),
                    github: $("#github").val(),
                    mbti: $("#mbti").val(),
                    intro: $("#intro").val(),
                    hobby: $("#hobby").val()
                };
                if (isEditMode && editingMemberId) {
                    await updateDoc(doc(db, "Team_8", editingMemberId), data);
                    alert("수정 완료!");
                } else {
                    await addDoc(collection(db, "Team_8"), data);
                    alert("등록 완료!");
                }
                $("#registerModal").fadeOut();
                loadTeamMembers();
            });

            document.getElementById("uploadBtn").addEventListener("click", function () {
                document.getElementById("imageFile").click();
            });
            document.getElementById("imageFile").addEventListener("change", function () {
                const fileName = this.files[0]?.name || "사진을 올려주세요!";
                document.getElementById("fileName").textContent = fileName;
            });

            loadTeamMembers();
        });