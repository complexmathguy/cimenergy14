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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.subscriber;

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
 * Subscriber for DynamicsFunctionBlock related events. .
 *
 * @author your_name_here
 */
@Component("dynamicsFunctionBlock-subscriber")
public class DynamicsFunctionBlockSubscriber extends BaseSubscriber {

  public DynamicsFunctionBlockSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<DynamicsFunctionBlock>, DynamicsFunctionBlock>
      dynamicsFunctionBlockSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllDynamicsFunctionBlockQuery(),
        ResponseTypes.multipleInstancesOf(DynamicsFunctionBlock.class),
        ResponseTypes.instanceOf(DynamicsFunctionBlock.class));
  }

  public SubscriptionQueryResult<DynamicsFunctionBlock, DynamicsFunctionBlock>
      dynamicsFunctionBlockSubscribe(@DestinationVariable UUID dynamicsFunctionBlockId) {
    return queryGateway.subscriptionQuery(
        new FindDynamicsFunctionBlockQuery(
            new LoadDynamicsFunctionBlockFilter(dynamicsFunctionBlockId)),
        ResponseTypes.instanceOf(DynamicsFunctionBlock.class),
        ResponseTypes.instanceOf(DynamicsFunctionBlock.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
