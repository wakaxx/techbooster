using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Animation;
using System.Windows.Shapes;
using Microsoft.Phone.Controls;

namespace ListBoxSample
{
    public partial class MainPage : PhoneApplicationPage
    {
        // コンストラクター
        public MainPage()
        {
            InitializeComponent();
            /*
            for (int cnt = 0; cnt < 20; cnt++)
            {
                listBox1.Items.Add("sample " + cnt);
            }
            */

            initListParam();
        
        }

        private void initListParam()
        {
            ListParamData kobashinA = new ListParamData("kobashin","000000000","kobashinA",1);
            ListParamData kobashinB = new ListParamData("kobashin", "000000000", "kobashinB", 2);
            ListParamData kobashinC = new ListParamData("kobashin", "000000000", "kobashinC", 3);
            ListParamData kobashinD = new ListParamData("kobashin", "000000000", "kobashinD", 4);
            ListParamData kobashinE = new ListParamData("kobashin", "000000000", "kobashinD", 5);

            listBox1.Items.Add(kobashinA);
            listBox1.Items.Add(kobashinB);
            listBox1.Items.Add(kobashinC);
            listBox1.Items.Add(kobashinD);
            listBox1.Items.Add(kobashinE);



        }

    }

    public class ListParamData
    {
        public String NAME;       // 名前
        public String PHONE;     // 電話番号
        public String TWITTER;   // TwitterId
        public long _ID;              // ID

        // コンストラクタ
        public ListParamData(String mName, String mPhone, String mTwitter, long Id)
        {
            NAME = mName;
            PHONE = mPhone;
            TWITTER = mTwitter;
            _ID = Id;
        }

        // 名前とTwitterIdの出力
        public String dump()
        {
            return "name:" + NAME + "(@" + TWITTER + ")";
        }

        // ToStringメソッド
        public override string ToString()
        {
            // ToStringメソッドでreturnした値がリスト表示される
            return "" + _ID + " " + NAME;
        }
    }
}