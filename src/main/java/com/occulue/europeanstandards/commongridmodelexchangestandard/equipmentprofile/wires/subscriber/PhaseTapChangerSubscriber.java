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
 * Subscriber for PhaseTapChanger related events. .
 *
 * @author your_name_here
 */
@Component("phaseTapChanger-subscriber")
public class PhaseTapChangerSubscriber extends BaseSubscriber {

  public PhaseTapChangerSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<PhaseTapChanger>, PhaseTapChanger>
      phaseTapChangerSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllPhaseTapChangerQuery(),
        ResponseTypes.multipleInstancesOf(PhaseTapChanger.class),
        ResponseTypes.instanceOf(PhaseTapChanger.class));
  }

  public SubscriptionQueryResult<PhaseTapChanger, PhaseTapChanger> phaseTapChangerSubscribe(
      @DestinationVariable UUID phaseTapChangerId) {
    return queryGateway.subscriptionQuery(
        new FindPhaseTapChangerQuery(new LoadPhaseTapChangerFilter(phaseTapChangerId)),
        ResponseTypes.instanceOf(PhaseTapChanger.class),
        ResponseTypes.instanceOf(PhaseTapChanger.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
