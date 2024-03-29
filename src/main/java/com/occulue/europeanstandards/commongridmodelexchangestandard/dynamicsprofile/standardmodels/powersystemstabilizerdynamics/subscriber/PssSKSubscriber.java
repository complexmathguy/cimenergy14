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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.powersystemstabilizerdynamics.subscriber;

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
 * Subscriber for PssSK related events. .
 *
 * @author your_name_here
 */
@Component("pssSK-subscriber")
public class PssSKSubscriber extends BaseSubscriber {

  public PssSKSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<PssSK>, PssSK> pssSKSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllPssSKQuery(),
        ResponseTypes.multipleInstancesOf(PssSK.class),
        ResponseTypes.instanceOf(PssSK.class));
  }

  public SubscriptionQueryResult<PssSK, PssSK> pssSKSubscribe(@DestinationVariable UUID pssSKId) {
    return queryGateway.subscriptionQuery(
        new FindPssSKQuery(new LoadPssSKFilter(pssSKId)),
        ResponseTypes.instanceOf(PssSK.class),
        ResponseTypes.instanceOf(PssSK.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
