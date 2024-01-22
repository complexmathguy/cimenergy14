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
 * Subscriber for PssSB4 related events. .
 *
 * @author your_name_here
 */
@Component("pssSB4-subscriber")
public class PssSB4Subscriber extends BaseSubscriber {

  public PssSB4Subscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<PssSB4>, PssSB4> pssSB4Subscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllPssSB4Query(),
        ResponseTypes.multipleInstancesOf(PssSB4.class),
        ResponseTypes.instanceOf(PssSB4.class));
  }

  public SubscriptionQueryResult<PssSB4, PssSB4> pssSB4Subscribe(
      @DestinationVariable UUID pssSB4Id) {
    return queryGateway.subscriptionQuery(
        new FindPssSB4Query(new LoadPssSB4Filter(pssSB4Id)),
        ResponseTypes.instanceOf(PssSB4.class),
        ResponseTypes.instanceOf(PssSB4.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
