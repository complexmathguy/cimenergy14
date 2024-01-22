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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.voltageadjusterdynamics.subscriber;

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
 * Subscriber for VAdjIEEE related events. .
 *
 * @author your_name_here
 */
@Component("vAdjIEEE-subscriber")
public class VAdjIEEESubscriber extends BaseSubscriber {

  public VAdjIEEESubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<VAdjIEEE>, VAdjIEEE> vAdjIEEESubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllVAdjIEEEQuery(),
        ResponseTypes.multipleInstancesOf(VAdjIEEE.class),
        ResponseTypes.instanceOf(VAdjIEEE.class));
  }

  public SubscriptionQueryResult<VAdjIEEE, VAdjIEEE> vAdjIEEESubscribe(
      @DestinationVariable UUID vAdjIEEEId) {
    return queryGateway.subscriptionQuery(
        new FindVAdjIEEEQuery(new LoadVAdjIEEEFilter(vAdjIEEEId)),
        ResponseTypes.instanceOf(VAdjIEEE.class),
        ResponseTypes.instanceOf(VAdjIEEE.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
