package com.gofteam.cottagerenren.widget;

import java.util.ArrayList;
import java.util.List;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;

import com.gofteam.cottagerenren.MainPageActivity;
import com.gofteam.cottagerenren.R;
import com.gofteam.cottagerenren.adapter.LeftPanelExListViewAdapter;
import com.gofteam.cottagerenren.entity.LeftPanelListItem;
/**
 * Created by spmno on 13-9-13.
 */
public class MenuFragment extends Fragment {
    int index = -1;
    private ExpandableListView expandableListView;
    private LeftPanelExListViewAdapter exListViewAdapter;
    private List<LeftPanelListItem> listItems = new ArrayList<LeftPanelListItem>();
    private String[] groupNames;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_left_panel);
        /*
        //set the preference xml to the content view
        addPreferencesFromResource(R.xml.menu);
        //add listener
        findPreference("a").setOnPreferenceClickListener(this);
        findPreference("b").setOnPreferenceClickListener(this);
        findPreference("n").setOnPreferenceClickListener(this);
        */

        
    }
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //inflater the layout
        Resources resources = this.getResources();
        groupNames = resources.getStringArray(R.array.left_panel_group_names);
        String[] firstGroupNames = resources.getStringArray(R.array.left_panel_first_group_names);
        String[] secondGroupNames = resources.getStringArray(R.array.left_panel_second_group_names);
        String[] thirdGroupNames = resources.getStringArray(R.array.left_panel_third_group_names);

        int[] firstGroupIcon = {
             R.drawable.left_panel_item_newsfeed_icon_selector,
                R.drawable.left_panel_item_message_icon_selector,
                R.drawable.left_panel_item_chat_icon_selector,
                R.drawable.left_panel_item_friends_icon_selector,
                R.drawable.left_panel_item_search_icon_selector,
        };

        int[] secondGroupIcon = {
                R.drawable.left_panel_item_location_icon_selector,
                R.drawable.left_panel_item_mainpage_icon_selector,
                R.drawable.left_panel_item_hot_icon_selector,
                R.drawable.left_panel_item_apps_icon_selector,
        };

        int[] thirdGroupIcon = {
                R.drawable.left_panel_item_settings_icon_selector,
                R.drawable.left_panel_item_layout_icon_selector,
        };

        addGroup(0, firstGroupNames, firstGroupIcon);
        addGroup(1, secondGroupNames, secondGroupIcon);
        addGroup(2, thirdGroupNames, thirdGroupIcon);
        
        View view = inflater.inflate(R.layout.activity_left_panel, null);
        
        //userIcon = (ImageView)findViewById(R.id.iv_user_icon);
        //nickName = (TextView)findViewById(R.id.tv_nickname);
        expandableListView = (ExpandableListView)view.findViewById(R.id.elv_list_view);
        exListViewAdapter = new LeftPanelExListViewAdapter(this, listItems);
        expandableListView.setAdapter(exListViewAdapter);
        return view;
    }

     /*
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        expandableListView = (ExpandableListView) view.findViewById(R.id.elv_list_view);
        exListViewAdapter = new LeftPanelExListViewAdapter(this, listItems);
        expandableListView.setAdapter(exListViewAdapter);
        //listView.setGroupIndicator(null); // I don't need group indicator on left
    }
    */
    
    private void addGroup(int groupId, String[] names, int[] icons) {
        LeftPanelListItem listItem = new LeftPanelListItem();
        listItem.setId(groupId);
        listItem.setName(groupNames[groupId]);

        ArrayList<LeftPanelListItem> firstGroup = new ArrayList<LeftPanelListItem>();
        for (int i = 0; i < names.length; ++i) {
            LeftPanelListItem leftPanelListItem = new LeftPanelListItem();
            leftPanelListItem.setId(i);
            leftPanelListItem.setName(names[i]);
            leftPanelListItem.setDrawableId(icons[i]);
            firstGroup.add(leftPanelListItem);
        }

        listItem.setGroups(firstGroup);
        listItems.add(listItem);
    }
}