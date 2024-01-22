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
 * Subscriber for PssWECC related events. .
 *
 * @author your_name_here
 */
@Component("pssWECC-subscriber")
public class PssWECCSubscriber extends BaseSubscriber {

  public PssWECCSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<PssWECC>, PssWECC> pssWECCSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllPssWECCQuery(),
        ResponseTypes.multipleInstancesOf(PssWECC.class),
        ResponseTypes.instanceOf(PssWECC.class));
  }

  public SubscriptionQueryResult<PssWECC, PssWECC> pssWECCSubscribe(
      @DestinationVariable UUID pssWECCId) {
    return queryGateway.subscriptionQuery(
        new FindPssWECCQuery(new LoadPssWECCFilter(pssWECCId)),
        ResponseTypes.instanceOf(PssWECC.class),
        ResponseTypes.instanceOf(PssWECC.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
