package common;
/**
 * システムメッセージ
 * @author hayakawa
 */
public class SystemMessage{
    // ***** 定数 *****
    // メッセージID
    public static enum ID_MESSAGE{
        N0001
      , N0002
      , N0003
      , N0004
      , N0005
      , N0006
      , N0007
      , E0001
      , E0002
    ;}
    // メッセージ
    private static final String N0001_MESSAGE = "メニューを選択して下さい\n0:社員追加/1:終了";
    private static final String N0002_MESSAGE = "追加社員を選択して下さい\n0:一般職/1:管理職";
    private static final String N0003_MESSAGE = "氏名(必須：10文字まで)を入力して下さい";
    private static final String N0004_MESSAGE = "年齢(必須：0以上の数値)を入力して下さい";
    private static final String N0005_MESSAGE = "職種(必須：5文字まで)を入力して下さい";
    private static final String N0006_MESSAGE = "役職(必須：5文字まで)を入力して下さい";
    private static final String N0007_MESSAGE = "(社員一覧)\n氏名\t\t年齢\t\t職種/役職";
    private static final String E0001_MESSAGE = "メソッド呼出しのパラメータが不正です";
    private static final String E0002_MESSAGE = "入出力エラーが発生しました";

    /**
     * メッセージ取得
     * @param idMessage ID_MESSAGE メッセージID
     * @return String メッセージ
     */
    public static String getMessage(ID_MESSAGE idMessage){
        String message = null;
        
        switch(idMessage){
        case N0001:
            message = N0001_MESSAGE;
            break;
        case N0002:
            message = N0002_MESSAGE;
            break;
        case N0003:
            message = N0003_MESSAGE;
            break;
        case N0004:
            message = N0004_MESSAGE;
            break;
        case N0005:
            message = N0005_MESSAGE;
            break;
        case N0006:
            message = N0006_MESSAGE;
            break;
        case N0007:
            message = N0007_MESSAGE;
            break;
        case E0001:
            message = E0001_MESSAGE;
            break;
        case E0002:
            message = E0002_MESSAGE;
            break;
        }
        
        return message;
    }

    /**
     * メッセージ出力
     * @param idMessage ID_MESSAGE メッセージID
     */
    public static void outMessage(ID_MESSAGE idMessage){
        System.out.println(getMessage(idMessage));
    }
}
