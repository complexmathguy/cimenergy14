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
 * Subscriber for SetPoint related events. .
 *
 * @author your_name_here
 */
@Component("setPoint-subscriber")
public class SetPointSubscriber extends BaseSubscriber {

  public SetPointSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<SetPoint>, SetPoint> setPointSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllSetPointQuery(),
        ResponseTypes.multipleInstancesOf(SetPoint.class),
        ResponseTypes.instanceOf(SetPoint.class));
  }

  public SubscriptionQueryResult<SetPoint, SetPoint> setPointSubscribe(
      @DestinationVariable UUID setPointId) {
    return queryGateway.subscriptionQuery(
        new FindSetPointQuery(new LoadSetPointFilter(setPointId)),
        ResponseTypes.instanceOf(SetPoint.class),
        ResponseTypes.instanceOf(SetPoint.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
