package com.label_gen.usps.domain.easypost.model;

import com.label_gen.usps.domain.easypost.net.EasyPostResource;

import java.util.List;

public class WebhookCollection extends EasyPostResource {
    List<Webhook> webhooks;

    public List<Webhook> getWebhooks() {
        return webhooks;
    }
    public void setWebhooks(List<Webhook> webhooks) {
        this.webhooks = webhooks;
    }
}
