package learning.android.learning_listview_in_android.CountryEx2;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

import learning.android.learning_listview_in_android.CountryModelClass;
import learning.android.learning_listview_in_android.R;

public class CustomAdapter2 extends ArrayAdapter<CountryModelClass> {

    ArrayList<CountryModelClass> arrayList;
    Context context;
    public CustomAdapter2(@NonNull Context context, int resource, @NonNull ArrayList<CountryModelClass> countryArrayList, ArrayList<CountryModelClass> arrayList){
        super(context, R.layout.item_list_layout, arrayList);
        this.arrayList = arrayList;
        this.context = context;
    }


    private static class ViewHolder{
        TextView txt_countryName;
        TextView txt_CupWinCount;
        ImageView img_countryFlag;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
// get the data item for this position
        CountryModelClass model = getItem(position);
        ViewHolder viewHolder;
        if(convertView == null){
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_list_layout, parent, false);
            viewHolder.txt_countryName = (TextView) convertView.findViewById(R.id.countryName);
            viewHolder.txt_CupWinCount = (TextView) convertView.findViewById(R.id.cup_win_desc);
            viewHolder.img_countryFlag = (ImageView) convertView.findViewById(R.id.countryImage);
            convertView.setTag(viewHolder);
        }
        else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.txt_countryName.setText(model.getCountryName());
        viewHolder.txt_CupWinCount.setText(model.getCup_win_count());
        viewHolder.img_countryFlag.setImageResource(model.getCountryFlag());
        return  convertView;
    }
}
