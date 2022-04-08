package rr.chrd.kiemtienqua.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ViewModelData : ViewModel() {

    private val homeDesc = MutableLiveData<String>().apply {

        value = "Kiếm tiền bằng điện thoại Đây là một số cách phổ biến để kiếm tiền bằng điện thoại." +
                " Câu hỏi đặt ra cho nhiều người là điều này có đúng không, có thực sự xảy ra được không?" +
                " Câu trả lời là có, khi chúng ta bước vào thời đại hiện đại, thực sự có thể ứng dụng này" +
                " chứa thứ gì đó mà bạn có thể kiếm tiền bằng cả internet và điện thoại di động của mình." +
                " Cách phù hợp để bạn kiếm tiền bằng cách sử dụng internet và điện thoại của bạn Ứng dụng" +
                " này chứa các cách thức và thử nghiệm pháp lý được đảm bảo thực sự, không chỉ là phỏng đoán," +
                " chúng tôi sẽ thảo luận chi tiết về những cách có thể xảy ra mà tại một thời điểm nào đó," +
                " một đại dịch như ngày nay sẽ thực hiện Có lợi cho tất cả chúng ta. Ứng dụng này được chia" +
                " thành bốn cuộc thảo luận đầu tiên là bạn đọc từ đây bạn có thể đọc thông tin chỉ" +
                " ở đây bạn có thể đọc trong ứng dụng này. Tìm kiếm một công việc trong cuộc sống thực" +
                " là rất khác biệt, tốt hơn và tiết kiệm tiền bạc và thời gian hơn."
    }

    val hDesc : LiveData<String> = homeDesc


    private var tipsList = ArrayList<TipsModel>()

    private var tipsTitle = arrayListOf(

        "Bán đồ cũ của bạn",
        "Bán dữ liệu của bạn",
        "Người tham gia thử nghiệm",
        "Điền vào bản khảo sát"

    )

    private var tipsDesc = arrayListOf(

        "Bạn có quần áo, đồ đạc hoặc sách cũ cần chuyển đi không? (Ồ, dù sao đi nữa!)" +
                " Có rất nhiều ứng dụng dành cho thiết bị di động mà bạn có thể sử dụng" +
                " để bán chúng và kiếm thêm tiền. Hãy xem và sử dụng ứng dụng này để bán" +
                " công nghệ và phương tiện như điện thoại di động, trò chơi, DVD, CD và sách." +
                " Nó cung cấp giao hàng miễn phí cho tất cả các đơn đặt hàng và thanh toán nhanh chóng" +
                " vào ngày hôm sau cho các mặt hàng bạn bán. Một tính năng thú vị là khả năng quét mã" +
                " vạch của một mặt hàng và ước tính ngay giá trị của nó.",

        "Đối với một số người, ý tưởng cài đặt một ứng dụng trên điện thoại của họ" +
                " và \"bán\" dữ liệu của bạn là một hành động xâm phạm quyền riêng tư." +
                " Nhưng nếu bạn không nghĩ vậy thì đây là một trong những cách lý tưởng để" +
                " kiếm tiền từ điện thoại mà không cần làm thêm. Ví dụ, Nielsen là một trong" +
                " những công ty nghiên cứu lớn nhất trên thị trường toàn cầu. Đó là lý do tại" +
                " sao họ thích xem những gì bạn đang làm trên điện thoại của mình - và họ sẵn" +
                " sàng trả tiền cho việc đó. Để sử dụng Computer Nielsen & panel cho Mobile Panel," +
                " tất cả những gì bạn cần làm là tải xuống một ứng dụng di động an toàn. Đây là!" +
                " Ứng dụng sẽ theo dõi và ghi lại cách bạn sử dụng điện thoại, cung cấp cho các" +
                " công ty dữ liệu nghiên cứu thị trường có giá trị mà họ cần. Sau khi đăng ký," +
                " bạn có thể kiếm được tín dụng thẻ quà tặng lên đến \$50.",

        "Các thương hiệu muốn biết mọi người nghĩ gì về sản phẩm và dịch vụ của họ." +
                " Một số người trong số họ sẽ trả tiền cho bạn để nói với họ những gì bạn nghĩ." +
                " Người dùng Thử nghiệm là một công ty giúp các thương hiệu có được phản hồi quan " +
                "trọng để họ có thể tiếp tục cải thiện hiệu quả của sản phẩm của mình. Theo trang web," +
                " những người tham gia có thể kiếm được 4 đô la cho bài kiểm tra người dùng 5 phút và" +
                " 10 đô la cho bài kiểm tra người dùng kéo dài 20 phút. Đối với các cuộc phỏng vấn nhỏ," +
                " bạn có thể kiếm được từ \$ 40 đến \$ 120. Để đăng ký, bạn cần trả lời một số câu hỏi" +
                " sàng lọc để UserT Testing đối sánh bạn với các sản phẩm và dịch vụ có liên quan để dùng thử." +
                " uTest là một công ty khác để xem bạn có quan tâm đến việc thử nghiệm người dùng hay không.",

        "Bạn có thể đã nghe nói về các cuộc khảo sát trước đây. Mặc dù chúng có thể không phải" +
                " là cách sử dụng thời gian tuyệt đối của bạn, nhưng chúng có thể là một ý tưởng" +
                " hay nếu bạn đang gặp khó khăn ở nhà, trong giao tiếp hàng ngày hoặc xếp hàng chờ đợi tại DMV." +
                " Hãy cùng xem một số ứng dụng khảo sát phổ biến. Thưởng cho bạn khi thực hiện" +
                " các cuộc khảo sát cũng như các hoạt động khác như xem video, chơi trò chơi điện" +
                " tử và đọc email. Ngoài việc được trả tiền, các thành viên cũng có thể nhận được" +
                " các lợi ích dưới dạng phiếu giảm giá và hoàn tiền khi mua hàng trực tuyến." +
                " Ngoài việc trả lời các câu hỏi khảo sát, bạn cũng có thể kiếm được phần thưởng" +
                " khi chia sẻ dữ liệu duyệt web của mình. Mỗi khi bạn trả lời một cuộc khảo sát hoặc" +
                " cung cấp dữ liệu, bạn sẽ kiếm được điểm để đổi thành thẻ quà tặng hoặc tiền mặt."
    )


    private var tipsInfo = MutableLiveData<List<TipsModel>>()
     val tpsNf : LiveData<List<TipsModel>>
    get() = tipsInfo

    private val errorH = CoroutineExceptionHandler { _, _ ->
        tipsInfo.postValue(null)
    }
    fun tipsFun() : MutableLiveData<List<TipsModel>>{
        viewModelScope.launch(errorH + Dispatchers.IO){
            for (n in tipsTitle.indices){
                tipsList.add(TipsModel(tipsTitle[n],tipsDesc[n]))
            }
            tipsInfo.postValue(tipsList)
        }
        return tipsInfo
    }


    private var guideList = ArrayList<GuideModel>()


    private var guideDesc = arrayListOf(
        "Điền vào bản khảo sát - bạn có thể đã nghe nói về các cuộc khảo sát trước đây." +
                " Mặc dù chúng có thể không phải là cách sử dụng thời gian của bạn tốt nhất," +
                " nhưng chúng có thể là một ý tưởng hay nếu bạn đang ở nhà, giao tiếp hàng ngày" +
                " hoặc xếp hàng chờ đợi tại DMV. Hãy cùng xem một số ứng dụng khảo sát phổ biến." +
                " Thưởng cho bạn khi thực hiện các cuộc khảo sát và các hoạt động khác như xem video," +
                " chơi trò chơi điện tử và đọc email. Ngoài việc được trả tiền, các thành viên" +
                " còn nhận được các lợi ích dưới dạng phiếu giảm giá và hoàn tiền khi mua sắm trực tuyến." +
                " Ngoài việc trả lời các câu hỏi khảo sát, bạn cũng có thể kiếm được phần thưởng " +
                "khi chia sẻ dữ liệu duyệt web của mình. Mỗi khi bạn trả lời một cuộc khảo sát hoặc" +
                " cung cấp dữ liệu, bạn sẽ kiếm được điểm để đổi thành thẻ quà tặng hoặc tiền mặt.",

        "Sử dụng Đầu tư Rủi ro Thấp Loại đầu tư trực tuyến này là hoàn hảo nếu bạn muốn đa dạng hóa" +
                " danh mục đầu tư của mình đồng thời bù đắp bất kỳ tổn thất nào có thể xảy ra nếu các" +
                " cổ phiếu rủi ro giảm giá trị. Các khoản đầu tư rủi ro thấp là một mạng lưới an toàn" +
                " cho danh mục đầu tư của bạn và chúng có thể giúp bạn rất nhiều khi bạn tiếp tục mua" +
                " và bán các cổ phiếu biến động đã tăng đều về giá trị trong những năm qua. Tất nhiên," +
                " những khoản đầu tư này sẽ không bảo vệ bạn khỏi tất cả các khoản thua lỗ, vì vậy hãy" +
                " đảm bảo rằng bạn vẫn lập kế hoạch cẩn thận và cho phép đa dạng hóa để giúp bạn trụ vững" +
                " trong một thị trường đầy biến động. Biết Rủi ro Đầu tư của Bạn Nếu bạn muốn kiếm tiền từ " +
                "đầu tư trực tuyến, cách chắc chắn là xác định rủi ro đầu tư của bạn."
    )

    private var guideInfo = MutableLiveData<List<GuideModel>>()
    val gdNf : LiveData<List<GuideModel>>
    get() = guideInfo


    private val errorG = CoroutineExceptionHandler { _, _ ->
        guideInfo.postValue(null)
    }

    fun guideFun() : MutableLiveData<List<GuideModel>>{
        viewModelScope.launch(errorG + Dispatchers.IO){
            for (n in 0 until guideDesc.size)
                guideList.add((GuideModel(guideDesc[n])))

            guideInfo.postValue(guideList)
        }
        return  guideInfo
    }
}