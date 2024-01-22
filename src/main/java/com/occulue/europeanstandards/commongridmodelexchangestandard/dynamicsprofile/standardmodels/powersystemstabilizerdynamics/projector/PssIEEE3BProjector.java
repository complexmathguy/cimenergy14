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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.powersystemstabilizerdynamics.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.powersystemstabilizerdynamics.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Logger;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Projector for PssIEEE3B as outlined for the CQRS pattern. All event handling and query handling
 * related to PssIEEE3B are invoked here and dispersed as an event to be handled elsewhere.
 *
 * <p>Commands are handled by PssIEEE3BAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("pssIEEE3B")
@Component("pssIEEE3B-projector")
public class PssIEEE3BProjector extends PssIEEE3BEntityProjector {

  // core constructor
  public PssIEEE3BProjector(PssIEEE3BRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreatePssIEEE3BEvent
   */
  @EventHandler(payloadType = CreatePssIEEE3BEvent.class)
  public void handle(CreatePssIEEE3BEvent event) {
    LOGGER.info("handling CreatePssIEEE3BEvent - " + event);
    PssIEEE3B entity = new PssIEEE3B();
    entity.setPssIEEE3BId(event.getPssIEEE3BId());
    entity.setInputSignal1Type(event.getInputSignal1Type());
    entity.setInputSignal2Type(event.getInputSignal2Type());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE3B(entity);
  }

  /*
   * @param	event UpdatePssIEEE3BEvent
   */
  @EventHandler(payloadType = UpdatePssIEEE3BEvent.class)
  public void handle(UpdatePssIEEE3BEvent event) {
    LOGGER.info("handling UpdatePssIEEE3BEvent - " + event);

    PssIEEE3B entity = new PssIEEE3B();
    entity.setPssIEEE3BId(event.getPssIEEE3BId());
    entity.setA1(event.getA1());
    entity.setA2(event.getA2());
    entity.setA3(event.getA3());
    entity.setA4(event.getA4());
    entity.setA5(event.getA5());
    entity.setA6(event.getA6());
    entity.setA7(event.getA7());
    entity.setA8(event.getA8());
    entity.setInputSignal1Type(event.getInputSignal1Type());
    entity.setInputSignal2Type(event.getInputSignal2Type());
    entity.setKs1(event.getKs1());
    entity.setKs2(event.getKs2());
    entity.setT1(event.getT1());
    entity.setT2(event.getT2());
    entity.setTw1(event.getTw1());
    entity.setTw2(event.getTw2());
    entity.setTw3(event.getTw3());
    entity.setVstmax(event.getVstmax());
    entity.setVstmin(event.getVstmin());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE3B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE3B(entity);
  }

  /*
   * @param	event DeletePssIEEE3BEvent
   */
  @EventHandler(payloadType = DeletePssIEEE3BEvent.class)
  public void handle(DeletePssIEEE3BEvent event) {
    LOGGER.info("handling DeletePssIEEE3BEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    PssIEEE3B entity = delete(event.getPssIEEE3BId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE3B(entity);
  }

  /*
   * @param	event AssignA1ToPssIEEE3BEvent
   */
  @EventHandler(payloadType = AssignA1ToPssIEEE3BEvent.class)
  public void handle(AssignA1ToPssIEEE3BEvent event) {
    LOGGER.info("handling AssignA1ToPssIEEE3BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssIEEE3B entity = assignA1(event.getPssIEEE3BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE3B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE3B(entity);
  }

  /*
   * @param	event UnAssignA1FromPssIEEE3BEvent
   */
  @EventHandler(payloadType = UnAssignA1FromPssIEEE3BEvent.class)
  public void handle(UnAssignA1FromPssIEEE3BEvent event) {
    LOGGER.info("handling UnAssignA1FromPssIEEE3BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssIEEE3B entity = unAssignA1(event.getPssIEEE3BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE3B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE3B(entity);
  }

  /*
   * @param	event AssignA2ToPssIEEE3BEvent
   */
  @EventHandler(payloadType = AssignA2ToPssIEEE3BEvent.class)
  public void handle(AssignA2ToPssIEEE3BEvent event) {
    LOGGER.info("handling AssignA2ToPssIEEE3BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssIEEE3B entity = assignA2(event.getPssIEEE3BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE3B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE3B(entity);
  }

  /*
   * @param	event UnAssignA2FromPssIEEE3BEvent
   */
  @EventHandler(payloadType = UnAssignA2FromPssIEEE3BEvent.class)
  public void handle(UnAssignA2FromPssIEEE3BEvent event) {
    LOGGER.info("handling UnAssignA2FromPssIEEE3BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssIEEE3B entity = unAssignA2(event.getPssIEEE3BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE3B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE3B(entity);
  }

  /*
   * @param	event AssignA3ToPssIEEE3BEvent
   */
  @EventHandler(payloadType = AssignA3ToPssIEEE3BEvent.class)
  public void handle(AssignA3ToPssIEEE3BEvent event) {
    LOGGER.info("handling AssignA3ToPssIEEE3BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssIEEE3B entity = assignA3(event.getPssIEEE3BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE3B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE3B(entity);
  }

  /*
   * @param	event UnAssignA3FromPssIEEE3BEvent
   */
  @EventHandler(payloadType = UnAssignA3FromPssIEEE3BEvent.class)
  public void handle(UnAssignA3FromPssIEEE3BEvent event) {
    LOGGER.info("handling UnAssignA3FromPssIEEE3BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssIEEE3B entity = unAssignA3(event.getPssIEEE3BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE3B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE3B(entity);
  }

  /*
   * @param	event AssignA4ToPssIEEE3BEvent
   */
  @EventHandler(payloadType = AssignA4ToPssIEEE3BEvent.class)
  public void handle(AssignA4ToPssIEEE3BEvent event) {
    LOGGER.info("handling AssignA4ToPssIEEE3BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssIEEE3B entity = assignA4(event.getPssIEEE3BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE3B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE3B(entity);
  }

  /*
   * @param	event UnAssignA4FromPssIEEE3BEvent
   */
  @EventHandler(payloadType = UnAssignA4FromPssIEEE3BEvent.class)
  public void handle(UnAssignA4FromPssIEEE3BEvent event) {
    LOGGER.info("handling UnAssignA4FromPssIEEE3BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssIEEE3B entity = unAssignA4(event.getPssIEEE3BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE3B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE3B(entity);
  }

  /*
   * @param	event AssignA5ToPssIEEE3BEvent
   */
  @EventHandler(payloadType = AssignA5ToPssIEEE3BEvent.class)
  public void handle(AssignA5ToPssIEEE3BEvent event) {
    LOGGER.info("handling AssignA5ToPssIEEE3BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssIEEE3B entity = assignA5(event.getPssIEEE3BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE3B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE3B(entity);
  }

  /*
   * @param	event UnAssignA5FromPssIEEE3BEvent
   */
  @EventHandler(payloadType = UnAssignA5FromPssIEEE3BEvent.class)
  public void handle(UnAssignA5FromPssIEEE3BEvent event) {
    LOGGER.info("handling UnAssignA5FromPssIEEE3BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssIEEE3B entity = unAssignA5(event.getPssIEEE3BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE3B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE3B(entity);
  }

  /*
   * @param	event AssignA6ToPssIEEE3BEvent
   */
  @EventHandler(payloadType = AssignA6ToPssIEEE3BEvent.class)
  public void handle(AssignA6ToPssIEEE3BEvent event) {
    LOGGER.info("handling AssignA6ToPssIEEE3BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssIEEE3B entity = assignA6(event.getPssIEEE3BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE3B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE3B(entity);
  }

  /*
   * @param	event UnAssignA6FromPssIEEE3BEvent
   */
  @EventHandler(payloadType = UnAssignA6FromPssIEEE3BEvent.class)
  public void handle(UnAssignA6FromPssIEEE3BEvent event) {
    LOGGER.info("handling UnAssignA6FromPssIEEE3BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssIEEE3B entity = unAssignA6(event.getPssIEEE3BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE3B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE3B(entity);
  }

  /*
   * @param	event AssignA7ToPssIEEE3BEvent
   */
  @EventHandler(payloadType = AssignA7ToPssIEEE3BEvent.class)
  public void handle(AssignA7ToPssIEEE3BEvent event) {
    LOGGER.info("handling AssignA7ToPssIEEE3BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssIEEE3B entity = assignA7(event.getPssIEEE3BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE3B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE3B(entity);
  }

  /*
   * @param	event UnAssignA7FromPssIEEE3BEvent
   */
  @EventHandler(payloadType = UnAssignA7FromPssIEEE3BEvent.class)
  public void handle(UnAssignA7FromPssIEEE3BEvent event) {
    LOGGER.info("handling UnAssignA7FromPssIEEE3BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssIEEE3B entity = unAssignA7(event.getPssIEEE3BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE3B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE3B(entity);
  }

  /*
   * @param	event AssignA8ToPssIEEE3BEvent
   */
  @EventHandler(payloadType = AssignA8ToPssIEEE3BEvent.class)
  public void handle(AssignA8ToPssIEEE3BEvent event) {
    LOGGER.info("handling AssignA8ToPssIEEE3BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssIEEE3B entity = assignA8(event.getPssIEEE3BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE3B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE3B(entity);
  }

  /*
   * @param	event UnAssignA8FromPssIEEE3BEvent
   */
  @EventHandler(payloadType = UnAssignA8FromPssIEEE3BEvent.class)
  public void handle(UnAssignA8FromPssIEEE3BEvent event) {
    LOGGER.info("handling UnAssignA8FromPssIEEE3BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssIEEE3B entity = unAssignA8(event.getPssIEEE3BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE3B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE3B(entity);
  }

  /*
   * @param	event AssignKs1ToPssIEEE3BEvent
   */
  @EventHandler(payloadType = AssignKs1ToPssIEEE3BEvent.class)
  public void handle(AssignKs1ToPssIEEE3BEvent event) {
    LOGGER.info("handling AssignKs1ToPssIEEE3BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssIEEE3B entity = assignKs1(event.getPssIEEE3BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE3B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE3B(entity);
  }

  /*
   * @param	event UnAssignKs1FromPssIEEE3BEvent
   */
  @EventHandler(payloadType = UnAssignKs1FromPssIEEE3BEvent.class)
  public void handle(UnAssignKs1FromPssIEEE3BEvent event) {
    LOGGER.info("handling UnAssignKs1FromPssIEEE3BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssIEEE3B entity = unAssignKs1(event.getPssIEEE3BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE3B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE3B(entity);
  }

  /*
   * @param	event AssignKs2ToPssIEEE3BEvent
   */
  @EventHandler(payloadType = AssignKs2ToPssIEEE3BEvent.class)
  public void handle(AssignKs2ToPssIEEE3BEvent event) {
    LOGGER.info("handling AssignKs2ToPssIEEE3BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssIEEE3B entity = assignKs2(event.getPssIEEE3BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE3B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE3B(entity);
  }

  /*
   * @param	event UnAssignKs2FromPssIEEE3BEvent
   */
  @EventHandler(payloadType = UnAssignKs2FromPssIEEE3BEvent.class)
  public void handle(UnAssignKs2FromPssIEEE3BEvent event) {
    LOGGER.info("handling UnAssignKs2FromPssIEEE3BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssIEEE3B entity = unAssignKs2(event.getPssIEEE3BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE3B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE3B(entity);
  }

  /*
   * @param	event AssignT1ToPssIEEE3BEvent
   */
  @EventHandler(payloadType = AssignT1ToPssIEEE3BEvent.class)
  public void handle(AssignT1ToPssIEEE3BEvent event) {
    LOGGER.info("handling AssignT1ToPssIEEE3BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssIEEE3B entity = assignT1(event.getPssIEEE3BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE3B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE3B(entity);
  }

  /*
   * @param	event UnAssignT1FromPssIEEE3BEvent
   */
  @EventHandler(payloadType = UnAssignT1FromPssIEEE3BEvent.class)
  public void handle(UnAssignT1FromPssIEEE3BEvent event) {
    LOGGER.info("handling UnAssignT1FromPssIEEE3BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssIEEE3B entity = unAssignT1(event.getPssIEEE3BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE3B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE3B(entity);
  }

  /*
   * @param	event AssignT2ToPssIEEE3BEvent
   */
  @EventHandler(payloadType = AssignT2ToPssIEEE3BEvent.class)
  public void handle(AssignT2ToPssIEEE3BEvent event) {
    LOGGER.info("handling AssignT2ToPssIEEE3BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssIEEE3B entity = assignT2(event.getPssIEEE3BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE3B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE3B(entity);
  }

  /*
   * @param	event UnAssignT2FromPssIEEE3BEvent
   */
  @EventHandler(payloadType = UnAssignT2FromPssIEEE3BEvent.class)
  public void handle(UnAssignT2FromPssIEEE3BEvent event) {
    LOGGER.info("handling UnAssignT2FromPssIEEE3BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssIEEE3B entity = unAssignT2(event.getPssIEEE3BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE3B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE3B(entity);
  }

  /*
   * @param	event AssignTw1ToPssIEEE3BEvent
   */
  @EventHandler(payloadType = AssignTw1ToPssIEEE3BEvent.class)
  public void handle(AssignTw1ToPssIEEE3BEvent event) {
    LOGGER.info("handling AssignTw1ToPssIEEE3BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssIEEE3B entity = assignTw1(event.getPssIEEE3BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE3B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE3B(entity);
  }

  /*
   * @param	event UnAssignTw1FromPssIEEE3BEvent
   */
  @EventHandler(payloadType = UnAssignTw1FromPssIEEE3BEvent.class)
  public void handle(UnAssignTw1FromPssIEEE3BEvent event) {
    LOGGER.info("handling UnAssignTw1FromPssIEEE3BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssIEEE3B entity = unAssignTw1(event.getPssIEEE3BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE3B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE3B(entity);
  }

  /*
   * @param	event AssignTw2ToPssIEEE3BEvent
   */
  @EventHandler(payloadType = AssignTw2ToPssIEEE3BEvent.class)
  public void handle(AssignTw2ToPssIEEE3BEvent event) {
    LOGGER.info("handling AssignTw2ToPssIEEE3BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssIEEE3B entity = assignTw2(event.getPssIEEE3BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE3B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE3B(entity);
  }

  /*
   * @param	event UnAssignTw2FromPssIEEE3BEvent
   */
  @EventHandler(payloadType = UnAssignTw2FromPssIEEE3BEvent.class)
  public void handle(UnAssignTw2FromPssIEEE3BEvent event) {
    LOGGER.info("handling UnAssignTw2FromPssIEEE3BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssIEEE3B entity = unAssignTw2(event.getPssIEEE3BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE3B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE3B(entity);
  }

  /*
   * @param	event AssignTw3ToPssIEEE3BEvent
   */
  @EventHandler(payloadType = AssignTw3ToPssIEEE3BEvent.class)
  public void handle(AssignTw3ToPssIEEE3BEvent event) {
    LOGGER.info("handling AssignTw3ToPssIEEE3BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssIEEE3B entity = assignTw3(event.getPssIEEE3BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE3B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE3B(entity);
  }

  /*
   * @param	event UnAssignTw3FromPssIEEE3BEvent
   */
  @EventHandler(payloadType = UnAssignTw3FromPssIEEE3BEvent.class)
  public void handle(UnAssignTw3FromPssIEEE3BEvent event) {
    LOGGER.info("handling UnAssignTw3FromPssIEEE3BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssIEEE3B entity = unAssignTw3(event.getPssIEEE3BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE3B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE3B(entity);
  }

  /*
   * @param	event AssignVstmaxToPssIEEE3BEvent
   */
  @EventHandler(payloadType = AssignVstmaxToPssIEEE3BEvent.class)
  public void handle(AssignVstmaxToPssIEEE3BEvent event) {
    LOGGER.info("handling AssignVstmaxToPssIEEE3BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssIEEE3B entity = assignVstmax(event.getPssIEEE3BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE3B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE3B(entity);
  }

  /*
   * @param	event UnAssignVstmaxFromPssIEEE3BEvent
   */
  @EventHandler(payloadType = UnAssignVstmaxFromPssIEEE3BEvent.class)
  public void handle(UnAssignVstmaxFromPssIEEE3BEvent event) {
    LOGGER.info("handling UnAssignVstmaxFromPssIEEE3BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssIEEE3B entity = unAssignVstmax(event.getPssIEEE3BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE3B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE3B(entity);
  }

  /*
   * @param	event AssignVstminToPssIEEE3BEvent
   */
  @EventHandler(payloadType = AssignVstminToPssIEEE3BEvent.class)
  public void handle(AssignVstminToPssIEEE3BEvent event) {
    LOGGER.info("handling AssignVstminToPssIEEE3BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssIEEE3B entity = assignVstmin(event.getPssIEEE3BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE3B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE3B(entity);
  }

  /*
   * @param	event UnAssignVstminFromPssIEEE3BEvent
   */
  @EventHandler(payloadType = UnAssignVstminFromPssIEEE3BEvent.class)
  public void handle(UnAssignVstminFromPssIEEE3BEvent event) {
    LOGGER.info("handling UnAssignVstminFromPssIEEE3BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssIEEE3B entity = unAssignVstmin(event.getPssIEEE3BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE3B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE3B(entity);
  }

  /**
   * Method to retrieve the PssIEEE3B via an PssIEEE3BPrimaryKey.
   *
   * @param id Long
   * @return PssIEEE3B
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public PssIEEE3B handle(FindPssIEEE3BQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getPssIEEE3BId());
  }

  /**
   * Method to retrieve a collection of all PssIEEE3Bs
   *
   * @param query FindAllPssIEEE3BQuery
   * @return List<PssIEEE3B>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<PssIEEE3B> handle(FindAllPssIEEE3BQuery query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindPssIEEE3B, but only if the id matches
   *
   * @param entity PssIEEE3B
   */
  protected void emitFindPssIEEE3B(PssIEEE3B entity) {
    LOGGER.info("handling emitFindPssIEEE3B");

    queryUpdateEmitter.emit(
        FindPssIEEE3BQuery.class,
        query -> query.getFilter().getPssIEEE3BId().equals(entity.getPssIEEE3BId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllPssIEEE3B
   *
   * @param entity PssIEEE3B
   */
  protected void emitFindAllPssIEEE3B(PssIEEE3B entity) {
    LOGGER.info("handling emitFindAllPssIEEE3B");

    queryUpdateEmitter.emit(FindAllPssIEEE3BQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(PssIEEE3BProjector.class.getName());
}
