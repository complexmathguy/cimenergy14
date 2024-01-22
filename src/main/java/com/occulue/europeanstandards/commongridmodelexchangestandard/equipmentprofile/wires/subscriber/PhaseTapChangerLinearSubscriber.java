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
 * Subscriber for PhaseTapChangerLinear related events. .
 *
 * @author your_name_here
 */
@Component("phaseTapChangerLinear-subscriber")
public class PhaseTapChangerLinearSubscriber extends BaseSubscriber {

  public PhaseTapChangerLinearSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<PhaseTapChangerLinear>, PhaseTapChangerLinear>
      phaseTapChangerLinearSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllPhaseTapChangerLinearQuery(),
        ResponseTypes.multipleInstancesOf(PhaseTapChangerLinear.class),
        ResponseTypes.instanceOf(PhaseTapChangerLinear.class));
  }

  public SubscriptionQueryResult<PhaseTapChangerLinear, PhaseTapChangerLinear>
      phaseTapChangerLinearSubscribe(@DestinationVariable UUID phaseTapChangerLinearId) {
    return queryGateway.subscriptionQuery(
        new FindPhaseTapChangerLinearQuery(
            new LoadPhaseTapChangerLinearFilter(phaseTapChangerLinearId)),
        ResponseTypes.instanceOf(PhaseTapChangerLinear.class),
        ResponseTypes.instanceOf(PhaseTapChangerLinear.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
