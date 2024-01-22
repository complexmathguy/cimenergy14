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
 * Subscriber for PssPTIST1 related events. .
 *
 * @author your_name_here
 */
@Component("pssPTIST1-subscriber")
public class PssPTIST1Subscriber extends BaseSubscriber {

  public PssPTIST1Subscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<PssPTIST1>, PssPTIST1> pssPTIST1Subscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllPssPTIST1Query(),
        ResponseTypes.multipleInstancesOf(PssPTIST1.class),
        ResponseTypes.instanceOf(PssPTIST1.class));
  }

  public SubscriptionQueryResult<PssPTIST1, PssPTIST1> pssPTIST1Subscribe(
      @DestinationVariable UUID pssPTIST1Id) {
    return queryGateway.subscriptionQuery(
        new FindPssPTIST1Query(new LoadPssPTIST1Filter(pssPTIST1Id)),
        ResponseTypes.instanceOf(PssPTIST1.class),
        ResponseTypes.instanceOf(PssPTIST1.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
