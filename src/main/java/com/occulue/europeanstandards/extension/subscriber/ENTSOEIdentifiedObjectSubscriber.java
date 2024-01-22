/**
 * ***************************************************************************** Turnstone Biologics
 * Confidential
 *
 * <p>2018 Turnstone Biologics All Rights Reserved.
 *
 * <p>This file is subject to the terms and conditions defined in file 'license.txt', which is part
 * of this source code package.
 *
 * <p>Contributors : Turnstone Biologics - General Release
 * ****************************************************************************
 */
package com.occulue.europeanstandards.extension.subscriber;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.exception.*;
import com.occulue.subscriber.*;
import java.util.*;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.queryhandling.SubscriptionQueryResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.stereotype.Component;

/**
 * Subscriber for ENTSOEIdentifiedObject related events. .
 *
 * @author your_name_here
 */
@Component("eNTSOEIdentifiedObject-subscriber")
public class ENTSOEIdentifiedObjectSubscriber extends BaseSubscriber {

  public ENTSOEIdentifiedObjectSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<ENTSOEIdentifiedObject>, ENTSOEIdentifiedObject>
      eNTSOEIdentifiedObjectSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllENTSOEIdentifiedObjectQuery(),
        ResponseTypes.multipleInstancesOf(ENTSOEIdentifiedObject.class),
        ResponseTypes.instanceOf(ENTSOEIdentifiedObject.class));
  }

  public SubscriptionQueryResult<ENTSOEIdentifiedObject, ENTSOEIdentifiedObject>
      eNTSOEIdentifiedObjectSubscribe(@DestinationVariable UUID eNTSOEIdentifiedObjectId) {
    return queryGateway.subscriptionQuery(
        new FindENTSOEIdentifiedObjectQuery(
            new LoadENTSOEIdentifiedObjectFilter(eNTSOEIdentifiedObjectId)),
        ResponseTypes.instanceOf(ENTSOEIdentifiedObject.class),
        ResponseTypes.instanceOf(ENTSOEIdentifiedObject.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
