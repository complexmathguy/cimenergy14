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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.controlarea.subscriber;

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
 * Subscriber for ControlArea related events. .
 *
 * @author your_name_here
 */
@Component("controlArea-subscriber")
public class ControlAreaSubscriber extends BaseSubscriber {

  public ControlAreaSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<ControlArea>, ControlArea> controlAreaSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllControlAreaQuery(),
        ResponseTypes.multipleInstancesOf(ControlArea.class),
        ResponseTypes.instanceOf(ControlArea.class));
  }

  public SubscriptionQueryResult<ControlArea, ControlArea> controlAreaSubscribe(
      @DestinationVariable UUID controlAreaId) {
    return queryGateway.subscriptionQuery(
        new FindControlAreaQuery(new LoadControlAreaFilter(controlAreaId)),
        ResponseTypes.instanceOf(ControlArea.class),
        ResponseTypes.instanceOf(ControlArea.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
