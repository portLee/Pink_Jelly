
    $('.slick').slick({
        dots: true,
        infinite: true,
        speed: 300,
        allows: true,
        prevArrow: $(".prev"),
        nextArrow: $(".next")
    });


// 슬라이드 버튼 호버시 이미지 변경
    $("button").hover(
        function () {
            let prevResult = $(this).hasClass("prev");
            let nextResult = $(this).hasClass("next");
            if (prevResult === true)
            {
                $("#prev-btn").removeClass("prev");
                $("#prev-btn").addClass("prevBlue");
            }
            else
            {
                $("#prev-btn").removeClass("prevBlue");
                $("#prev-btn").addClass("prev");
            }
            if (nextResult === true)
            {
                $("#next-btn").removeClass("next");
                $("#next-btn").addClass("nextBlue");
            }
            else
            {
                $("#next-btn").removeClass("nextBlue");
                $("#next-btn").addClass("next");
            }
        }
    );