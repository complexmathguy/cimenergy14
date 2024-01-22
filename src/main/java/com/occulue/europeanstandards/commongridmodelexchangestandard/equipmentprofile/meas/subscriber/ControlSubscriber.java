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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.meas.subscriber;

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
 * Subscriber for Control related events. .
 *
 * @author your_name_here
 */
@Component("control-subscriber")
public class ControlSubscriber extends BaseSubscriber {

  public ControlSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<Control>, Control> controlSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllControlQuery(),
        ResponseTypes.multipleInstancesOf(Control.class),
        ResponseTypes.instanceOf(Control.class));
  }

  public SubscriptionQueryResult<Control, Control> controlSubscribe(
      @DestinationVariable UUID controlId) {
    return queryGateway.subscriptionQuery(
        new FindControlQuery(new LoadControlFilter(controlId)),
        ResponseTypes.instanceOf(Control.class),
        ResponseTypes.instanceOf(Control.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
