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

namespace NavigationServiceSample
{
    public partial class Page1 : PhoneApplicationPage
    {
        public Page1()
        {
            InitializeComponent();
        }

        protected override void OnNavigatedTo(System.Windows.Navigation.NavigationEventArgs e)
        {
            base.OnNavigatedTo(e);

            // 格納先の変数準備
            string inputVal = "";

            if (NavigationContext.QueryString.TryGetValue("msg1", out inputVal))
            {
                // textBlock1にて取得したデータを表示
                textBlock1.Text = inputVal;
            }

        }
    }
}