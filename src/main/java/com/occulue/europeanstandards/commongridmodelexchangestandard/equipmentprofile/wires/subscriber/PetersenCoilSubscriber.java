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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.subscriber;

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
 * Subscriber for PetersenCoil related events. .
 *
 * @author your_name_here
 */
@Component("petersenCoil-subscriber")
public class PetersenCoilSubscriber extends BaseSubscriber {

  public PetersenCoilSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<PetersenCoil>, PetersenCoil> petersenCoilSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllPetersenCoilQuery(),
        ResponseTypes.multipleInstancesOf(PetersenCoil.class),
        ResponseTypes.instanceOf(PetersenCoil.class));
  }

  public SubscriptionQueryResult<PetersenCoil, PetersenCoil> petersenCoilSubscribe(
      @DestinationVariable UUID petersenCoilId) {
    return queryGateway.subscriptionQuery(
        new FindPetersenCoilQuery(new LoadPetersenCoilFilter(petersenCoilId)),
        ResponseTypes.instanceOf(PetersenCoil.class),
        ResponseTypes.instanceOf(PetersenCoil.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
