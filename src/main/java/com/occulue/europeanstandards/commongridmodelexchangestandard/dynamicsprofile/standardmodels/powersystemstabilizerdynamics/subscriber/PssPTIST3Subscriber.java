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
 * Subscriber for PssPTIST3 related events. .
 *
 * @author your_name_here
 */
@Component("pssPTIST3-subscriber")
public class PssPTIST3Subscriber extends BaseSubscriber {

  public PssPTIST3Subscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<PssPTIST3>, PssPTIST3> pssPTIST3Subscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllPssPTIST3Query(),
        ResponseTypes.multipleInstancesOf(PssPTIST3.class),
        ResponseTypes.instanceOf(PssPTIST3.class));
  }

  public SubscriptionQueryResult<PssPTIST3, PssPTIST3> pssPTIST3Subscribe(
      @DestinationVariable UUID pssPTIST3Id) {
    return queryGateway.subscriptionQuery(
        new FindPssPTIST3Query(new LoadPssPTIST3Filter(pssPTIST3Id)),
        ResponseTypes.instanceOf(PssPTIST3.class),
        ResponseTypes.instanceOf(PssPTIST3.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
