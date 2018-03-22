package to.msn.wings.minecraft_memo2;

import android.app.Application;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by 4163104 on 2017/12/18.
 */

public class Globals extends Application {

    public String[] base_member = {""};
    public String[] block_member = {""};
    public String[] tool_member = {""};
    public String[] armor_member = {""};
    public String[] truck_member = {""};
    public String[] machine_member = {""};
    public String[] food_member = {""};
    public String[] brewing_member = {""};
    public String[] dye_member = {""};
    public String[] other_member = {""};
    private final static String TAG = home.class.getSimpleName();

    public void GlobalsInit(){
        base_member = new String[] {"木材", "棒", "松明", "作業台", "かまど", "チェスト", "ベッド"};
        block_member = new String[] {"鉱石ブロック","グロウストーン","羊毛","色付き羊毛","TNT","ハーフブロック","階段","雪ブロック",
                "雪","粘土ブロック","レンガブロック","石レンガ","苔石レンガ","模様入り石レンガ","砂岩","赤砂岩","本棚","ジャック・オ・ランタン",
                "スイカ（ブロック）","ネザー水晶ブロック","模様入りネザー水晶ブロック","干草の俵","色付きテラコッタ","色付きガラス",
                "スライムブロック","花崗岩","安山岩","閃緑岩","磨かれた花崗岩","磨かれた安山岩","磨かれた閃緑岩","苔石","粗い土",
                "プリズマリン","プリズマリンレンガ","ダークプリズマリン","シーランタン","エンドストーンレンガ","プルプァブロック",
                "マグマブロック","ネザーウォートブロック","赤ネザーレンガ","骨ブロック","コンクリートパウダー"};
        tool_member = new String[] {"斧", "ツルハシ", "シャベル", "剣", "クワ", "弓", "矢", "マーキングの矢", "効果付きの矢", "火打石と打ち金",
                "バケツ", "コンパス", "時計", "釣り竿","白紙の地図","地図(拡張)","地図(複製)","ハサミ","ファイヤーチャージ","本と羽ペン",
                "著書/記入済みの本(コピー)","ニンジン付きの棒","首綱"};
        armor_member = new String[] {"ヘルメット","チェストプレート","レギンス","ブーツ","盾"};
        truck_member = new String[] {"トロッコ","かまど付きトロッコ","チェスト付きトロッコ","ホッパー付きトロッコ","TNT付きトロッコ",
                "レール","パワードレール","ディテクターレール","アクティベーターレール","ボート"};
        machine_member = new String[] {"木のドア","鉄のドア","木のトラップドア","鉄のトラップドア","フェンスゲート",
                "感圧式スイッチ","重量感圧板","ボタン","レバー","レッドストーントーチ",
                "レッドストーンリピーター","レッドストーンコンパレーター","ジュークボックス","音符ブロック","ドロッパー",
                "ディスペンサー","ピストン","粘着ピストン","レッドストーンランプ","トリップワイヤーフック",
                "トラップチェスト","ホッパー","レッドストーンブロック","日照センサー","オブザーバー"};
        food_member = new String[] {"ボウル","クッキー","キノコシチュー","パン","金のリンゴ (下位)",
                "砂糖", "パンプキンパイ","ケーキ","ウサギシチュー","ビートルートスープ"};
        brewing_member = new String[] {"醸造台","ガラス瓶","大釜","醗酵したクモの目","マグマクリーム","ブレイズパウダー","きらめくスイカ","金のニンジン"};
        dye_member = new String[] {"赤色","橙色","黄色","黄緑色","水色","空色","紫色","赤紫色","桃色","薄灰色","灰色"};
        other_member = new String[] {"エンチャントテーブル","金床","ビーコン","鉱物","金インゴット","金塊","鉄インゴット","鉄塊","レッドストーン","絵画",
                "額縁","植木鉢","看板","はしご","紙","本","革","スライムボール","フェンス","ネザーレンガフェンス","石の壁(苔石の壁)",
                "鉄格子","カーペット","板ガラス","色付きガラス板","骨粉","スイカの種","カボチャの種","エンダーアイ","エンダーチェスト",
                "花火の星","ロケット花火","旗","防具立て","エンダークリスタル","エンドロッド","シュルカーボックス"};
    }

    /**
     * 選択された画像ファイルパスを返す
     * @param context
     * @param uri
     * @return
     */
    public static String getImagePath(Context context, Uri uri) {

        String retPath = "";
        String id;

        if (uri == null) return retPath;

        {

            // 画像のファイルパスを取得
            Log.i(TAG, "uri.getAuthority(): " + (uri.getAuthority()));
            Cursor cursor = null;
            switch (uri.getAuthority()) {
                case "com.android.providers.media.documents":
                    //ギャラリーからの場合
                    id = DocumentsContract.getDocumentId(uri);
                    String selection = "_id=?";
                    String[] selectionArgs = new String[]{id.split(":")[1]};
                    cursor = context.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[]{MediaStore.Images.Media.DATA}, selection, selectionArgs, null);

                    if (cursor != null) {
                        // ファイルパスを取得して保存
                        if (cursor.moveToFirst()) {
                            retPath = cursor.getString(0);
                        }
                        cursor.close();
                    }
                    break;

                case "com.android.providers.downloads.documents":
                    // ダウンロードからの場合
                    id = DocumentsContract.getDocumentId(uri);
                    Uri docUri = ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(id));
                    cursor = context.getContentResolver().query(docUri, new String[]{MediaStore.Images.Media.DATA}, null, null, null);

                    if (cursor != null) {
                        // ファイルパスを取得して保存
                        if (cursor.moveToFirst()) {
                            retPath = cursor.getString(0);
                        }
                        cursor.close();
                    }
                    break;

                case "media":
                    // その他
                    try {
                        String[] projection = {MediaStore.MediaColumns.DATA};
                        // 画像のファイルパスを取得する
                        cursor = context.getContentResolver().query(uri, projection, null, null, null);
                        if (cursor != null) {
                            if (cursor.moveToFirst()) {
                                retPath = cursor.getString(0);
                            }
                            cursor.close();
                            if (retPath != null) {
                                File file = new File(retPath);
                            }
                        }
                    } catch (Exception e) {
                        Log.e(TAG, "画像パスの取得失敗k: " + e.getMessage());
                    }
                    break;

                default:
                    break;
            }


            Log.i(TAG, "選択された画像: " + retPath);
            return retPath;
        }
    }

    public static Bitmap setupBackgroundBitmap(ContentResolver contentResolver, String imagePath) {

        Bitmap bitmap = null;
        File file = new File(imagePath);
        Log.i(TAG,"file:"+file);
        try {
            Uri uri = Uri.fromFile(file);
            Log.i(TAG,"uri:"+uri);

            InputStream inputStream = new FileInputStream(file);

            Log.i(TAG,"inputStream: "+inputStream);

            bitmap = BitmapFactory.decodeStream(inputStream, null, null);
            inputStream.close();




        } catch (IOException e) {
            e.printStackTrace();
        }
        return bitmap;
    }


}
