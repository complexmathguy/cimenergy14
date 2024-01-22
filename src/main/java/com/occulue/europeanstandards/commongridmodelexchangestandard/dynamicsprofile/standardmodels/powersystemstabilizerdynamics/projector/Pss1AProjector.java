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
 * Projector for Pss1A as outlined for the CQRS pattern. All event handling and query handling
 * related to Pss1A are invoked here and dispersed as an event to be handled elsewhere.
 *
 * <p>Commands are handled by Pss1AAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("pss1A")
@Component("pss1A-projector")
public class Pss1AProjector extends Pss1AEntityProjector {

  // core constructor
  public Pss1AProjector(Pss1ARepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreatePss1AEvent
   */
  @EventHandler(payloadType = CreatePss1AEvent.class)
  public void handle(CreatePss1AEvent event) {
    LOGGER.info("handling CreatePss1AEvent - " + event);
    Pss1A entity = new Pss1A();
    entity.setPss1AId(event.getPss1AId());
    entity.setInputSignalType(event.getInputSignalType());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss1A(entity);
  }

  /*
   * @param	event UpdatePss1AEvent
   */
  @EventHandler(payloadType = UpdatePss1AEvent.class)
  public void handle(UpdatePss1AEvent event) {
    LOGGER.info("handling UpdatePss1AEvent - " + event);

    Pss1A entity = new Pss1A();
    entity.setPss1AId(event.getPss1AId());
    entity.setA1(event.getA1());
    entity.setA2(event.getA2());
    entity.setA3(event.getA3());
    entity.setA4(event.getA4());
    entity.setA5(event.getA5());
    entity.setA6(event.getA6());
    entity.setA7(event.getA7());
    entity.setA8(event.getA8());
    entity.setInputSignalType(event.getInputSignalType());
    entity.setKd(event.getKd());
    entity.setKs(event.getKs());
    entity.setT1(event.getT1());
    entity.setT2(event.getT2());
    entity.setT3(event.getT3());
    entity.setT4(event.getT4());
    entity.setT5(event.getT5());
    entity.setT6(event.getT6());
    entity.setTdelay(event.getTdelay());
    entity.setVcl(event.getVcl());
    entity.setVcu(event.getVcu());
    entity.setVrmax(event.getVrmax());
    entity.setVrmin(event.getVrmin());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss1A(entity);
  }

  /*
   * @param	event DeletePss1AEvent
   */
  @EventHandler(payloadType = DeletePss1AEvent.class)
  public void handle(DeletePss1AEvent event) {
    LOGGER.info("handling DeletePss1AEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    Pss1A entity = delete(event.getPss1AId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss1A(entity);
  }

  /*
   * @param	event AssignA1ToPss1AEvent
   */
  @EventHandler(payloadType = AssignA1ToPss1AEvent.class)
  public void handle(AssignA1ToPss1AEvent event) {
    LOGGER.info("handling AssignA1ToPss1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    Pss1A entity = assignA1(event.getPss1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss1A(entity);
  }

  /*
   * @param	event UnAssignA1FromPss1AEvent
   */
  @EventHandler(payloadType = UnAssignA1FromPss1AEvent.class)
  public void handle(UnAssignA1FromPss1AEvent event) {
    LOGGER.info("handling UnAssignA1FromPss1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    Pss1A entity = unAssignA1(event.getPss1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss1A(entity);
  }

  /*
   * @param	event AssignA2ToPss1AEvent
   */
  @EventHandler(payloadType = AssignA2ToPss1AEvent.class)
  public void handle(AssignA2ToPss1AEvent event) {
    LOGGER.info("handling AssignA2ToPss1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    Pss1A entity = assignA2(event.getPss1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss1A(entity);
  }

  /*
   * @param	event UnAssignA2FromPss1AEvent
   */
  @EventHandler(payloadType = UnAssignA2FromPss1AEvent.class)
  public void handle(UnAssignA2FromPss1AEvent event) {
    LOGGER.info("handling UnAssignA2FromPss1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    Pss1A entity = unAssignA2(event.getPss1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss1A(entity);
  }

  /*
   * @param	event AssignA3ToPss1AEvent
   */
  @EventHandler(payloadType = AssignA3ToPss1AEvent.class)
  public void handle(AssignA3ToPss1AEvent event) {
    LOGGER.info("handling AssignA3ToPss1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    Pss1A entity = assignA3(event.getPss1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss1A(entity);
  }

  /*
   * @param	event UnAssignA3FromPss1AEvent
   */
  @EventHandler(payloadType = UnAssignA3FromPss1AEvent.class)
  public void handle(UnAssignA3FromPss1AEvent event) {
    LOGGER.info("handling UnAssignA3FromPss1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    Pss1A entity = unAssignA3(event.getPss1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss1A(entity);
  }

  /*
   * @param	event AssignA4ToPss1AEvent
   */
  @EventHandler(payloadType = AssignA4ToPss1AEvent.class)
  public void handle(AssignA4ToPss1AEvent event) {
    LOGGER.info("handling AssignA4ToPss1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    Pss1A entity = assignA4(event.getPss1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss1A(entity);
  }

  /*
   * @param	event UnAssignA4FromPss1AEvent
   */
  @EventHandler(payloadType = UnAssignA4FromPss1AEvent.class)
  public void handle(UnAssignA4FromPss1AEvent event) {
    LOGGER.info("handling UnAssignA4FromPss1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    Pss1A entity = unAssignA4(event.getPss1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss1A(entity);
  }

  /*
   * @param	event AssignA5ToPss1AEvent
   */
  @EventHandler(payloadType = AssignA5ToPss1AEvent.class)
  public void handle(AssignA5ToPss1AEvent event) {
    LOGGER.info("handling AssignA5ToPss1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    Pss1A entity = assignA5(event.getPss1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss1A(entity);
  }

  /*
   * @param	event UnAssignA5FromPss1AEvent
   */
  @EventHandler(payloadType = UnAssignA5FromPss1AEvent.class)
  public void handle(UnAssignA5FromPss1AEvent event) {
    LOGGER.info("handling UnAssignA5FromPss1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    Pss1A entity = unAssignA5(event.getPss1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss1A(entity);
  }

  /*
   * @param	event AssignA6ToPss1AEvent
   */
  @EventHandler(payloadType = AssignA6ToPss1AEvent.class)
  public void handle(AssignA6ToPss1AEvent event) {
    LOGGER.info("handling AssignA6ToPss1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    Pss1A entity = assignA6(event.getPss1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss1A(entity);
  }

  /*
   * @param	event UnAssignA6FromPss1AEvent
   */
  @EventHandler(payloadType = UnAssignA6FromPss1AEvent.class)
  public void handle(UnAssignA6FromPss1AEvent event) {
    LOGGER.info("handling UnAssignA6FromPss1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    Pss1A entity = unAssignA6(event.getPss1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss1A(entity);
  }

  /*
   * @param	event AssignA7ToPss1AEvent
   */
  @EventHandler(payloadType = AssignA7ToPss1AEvent.class)
  public void handle(AssignA7ToPss1AEvent event) {
    LOGGER.info("handling AssignA7ToPss1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    Pss1A entity = assignA7(event.getPss1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss1A(entity);
  }

  /*
   * @param	event UnAssignA7FromPss1AEvent
   */
  @EventHandler(payloadType = UnAssignA7FromPss1AEvent.class)
  public void handle(UnAssignA7FromPss1AEvent event) {
    LOGGER.info("handling UnAssignA7FromPss1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    Pss1A entity = unAssignA7(event.getPss1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss1A(entity);
  }

  /*
   * @param	event AssignA8ToPss1AEvent
   */
  @EventHandler(payloadType = AssignA8ToPss1AEvent.class)
  public void handle(AssignA8ToPss1AEvent event) {
    LOGGER.info("handling AssignA8ToPss1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    Pss1A entity = assignA8(event.getPss1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss1A(entity);
  }

  /*
   * @param	event UnAssignA8FromPss1AEvent
   */
  @EventHandler(payloadType = UnAssignA8FromPss1AEvent.class)
  public void handle(UnAssignA8FromPss1AEvent event) {
    LOGGER.info("handling UnAssignA8FromPss1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    Pss1A entity = unAssignA8(event.getPss1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss1A(entity);
  }

  /*
   * @param	event AssignKdToPss1AEvent
   */
  @EventHandler(payloadType = AssignKdToPss1AEvent.class)
  public void handle(AssignKdToPss1AEvent event) {
    LOGGER.info("handling AssignKdToPss1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    Pss1A entity = assignKd(event.getPss1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss1A(entity);
  }

  /*
   * @param	event UnAssignKdFromPss1AEvent
   */
  @EventHandler(payloadType = UnAssignKdFromPss1AEvent.class)
  public void handle(UnAssignKdFromPss1AEvent event) {
    LOGGER.info("handling UnAssignKdFromPss1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    Pss1A entity = unAssignKd(event.getPss1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss1A(entity);
  }

  /*
   * @param	event AssignKsToPss1AEvent
   */
  @EventHandler(payloadType = AssignKsToPss1AEvent.class)
  public void handle(AssignKsToPss1AEvent event) {
    LOGGER.info("handling AssignKsToPss1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    Pss1A entity = assignKs(event.getPss1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss1A(entity);
  }

  /*
   * @param	event UnAssignKsFromPss1AEvent
   */
  @EventHandler(payloadType = UnAssignKsFromPss1AEvent.class)
  public void handle(UnAssignKsFromPss1AEvent event) {
    LOGGER.info("handling UnAssignKsFromPss1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    Pss1A entity = unAssignKs(event.getPss1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss1A(entity);
  }

  /*
   * @param	event AssignT1ToPss1AEvent
   */
  @EventHandler(payloadType = AssignT1ToPss1AEvent.class)
  public void handle(AssignT1ToPss1AEvent event) {
    LOGGER.info("handling AssignT1ToPss1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    Pss1A entity = assignT1(event.getPss1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss1A(entity);
  }

  /*
   * @param	event UnAssignT1FromPss1AEvent
   */
  @EventHandler(payloadType = UnAssignT1FromPss1AEvent.class)
  public void handle(UnAssignT1FromPss1AEvent event) {
    LOGGER.info("handling UnAssignT1FromPss1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    Pss1A entity = unAssignT1(event.getPss1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss1A(entity);
  }

  /*
   * @param	event AssignT2ToPss1AEvent
   */
  @EventHandler(payloadType = AssignT2ToPss1AEvent.class)
  public void handle(AssignT2ToPss1AEvent event) {
    LOGGER.info("handling AssignT2ToPss1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    Pss1A entity = assignT2(event.getPss1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss1A(entity);
  }

  /*
   * @param	event UnAssignT2FromPss1AEvent
   */
  @EventHandler(payloadType = UnAssignT2FromPss1AEvent.class)
  public void handle(UnAssignT2FromPss1AEvent event) {
    LOGGER.info("handling UnAssignT2FromPss1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    Pss1A entity = unAssignT2(event.getPss1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss1A(entity);
  }

  /*
   * @param	event AssignT3ToPss1AEvent
   */
  @EventHandler(payloadType = AssignT3ToPss1AEvent.class)
  public void handle(AssignT3ToPss1AEvent event) {
    LOGGER.info("handling AssignT3ToPss1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    Pss1A entity = assignT3(event.getPss1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss1A(entity);
  }

  /*
   * @param	event UnAssignT3FromPss1AEvent
   */
  @EventHandler(payloadType = UnAssignT3FromPss1AEvent.class)
  public void handle(UnAssignT3FromPss1AEvent event) {
    LOGGER.info("handling UnAssignT3FromPss1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    Pss1A entity = unAssignT3(event.getPss1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss1A(entity);
  }

  /*
   * @param	event AssignT4ToPss1AEvent
   */
  @EventHandler(payloadType = AssignT4ToPss1AEvent.class)
  public void handle(AssignT4ToPss1AEvent event) {
    LOGGER.info("handling AssignT4ToPss1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    Pss1A entity = assignT4(event.getPss1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss1A(entity);
  }

  /*
   * @param	event UnAssignT4FromPss1AEvent
   */
  @EventHandler(payloadType = UnAssignT4FromPss1AEvent.class)
  public void handle(UnAssignT4FromPss1AEvent event) {
    LOGGER.info("handling UnAssignT4FromPss1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    Pss1A entity = unAssignT4(event.getPss1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss1A(entity);
  }

  /*
   * @param	event AssignT5ToPss1AEvent
   */
  @EventHandler(payloadType = AssignT5ToPss1AEvent.class)
  public void handle(AssignT5ToPss1AEvent event) {
    LOGGER.info("handling AssignT5ToPss1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    Pss1A entity = assignT5(event.getPss1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss1A(entity);
  }

  /*
   * @param	event UnAssignT5FromPss1AEvent
   */
  @EventHandler(payloadType = UnAssignT5FromPss1AEvent.class)
  public void handle(UnAssignT5FromPss1AEvent event) {
    LOGGER.info("handling UnAssignT5FromPss1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    Pss1A entity = unAssignT5(event.getPss1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss1A(entity);
  }

  /*
   * @param	event AssignT6ToPss1AEvent
   */
  @EventHandler(payloadType = AssignT6ToPss1AEvent.class)
  public void handle(AssignT6ToPss1AEvent event) {
    LOGGER.info("handling AssignT6ToPss1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    Pss1A entity = assignT6(event.getPss1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss1A(entity);
  }

  /*
   * @param	event UnAssignT6FromPss1AEvent
   */
  @EventHandler(payloadType = UnAssignT6FromPss1AEvent.class)
  public void handle(UnAssignT6FromPss1AEvent event) {
    LOGGER.info("handling UnAssignT6FromPss1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    Pss1A entity = unAssignT6(event.getPss1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss1A(entity);
  }

  /*
   * @param	event AssignTdelayToPss1AEvent
   */
  @EventHandler(payloadType = AssignTdelayToPss1AEvent.class)
  public void handle(AssignTdelayToPss1AEvent event) {
    LOGGER.info("handling AssignTdelayToPss1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    Pss1A entity = assignTdelay(event.getPss1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss1A(entity);
  }

  /*
   * @param	event UnAssignTdelayFromPss1AEvent
   */
  @EventHandler(payloadType = UnAssignTdelayFromPss1AEvent.class)
  public void handle(UnAssignTdelayFromPss1AEvent event) {
    LOGGER.info("handling UnAssignTdelayFromPss1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    Pss1A entity = unAssignTdelay(event.getPss1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss1A(entity);
  }

  /*
   * @param	event AssignVclToPss1AEvent
   */
  @EventHandler(payloadType = AssignVclToPss1AEvent.class)
  public void handle(AssignVclToPss1AEvent event) {
    LOGGER.info("handling AssignVclToPss1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    Pss1A entity = assignVcl(event.getPss1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss1A(entity);
  }

  /*
   * @param	event UnAssignVclFromPss1AEvent
   */
  @EventHandler(payloadType = UnAssignVclFromPss1AEvent.class)
  public void handle(UnAssignVclFromPss1AEvent event) {
    LOGGER.info("handling UnAssignVclFromPss1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    Pss1A entity = unAssignVcl(event.getPss1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss1A(entity);
  }

  /*
   * @param	event AssignVcuToPss1AEvent
   */
  @EventHandler(payloadType = AssignVcuToPss1AEvent.class)
  public void handle(AssignVcuToPss1AEvent event) {
    LOGGER.info("handling AssignVcuToPss1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    Pss1A entity = assignVcu(event.getPss1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss1A(entity);
  }

  /*
   * @param	event UnAssignVcuFromPss1AEvent
   */
  @EventHandler(payloadType = UnAssignVcuFromPss1AEvent.class)
  public void handle(UnAssignVcuFromPss1AEvent event) {
    LOGGER.info("handling UnAssignVcuFromPss1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    Pss1A entity = unAssignVcu(event.getPss1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss1A(entity);
  }

  /*
   * @param	event AssignVrmaxToPss1AEvent
   */
  @EventHandler(payloadType = AssignVrmaxToPss1AEvent.class)
  public void handle(AssignVrmaxToPss1AEvent event) {
    LOGGER.info("handling AssignVrmaxToPss1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    Pss1A entity = assignVrmax(event.getPss1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss1A(entity);
  }

  /*
   * @param	event UnAssignVrmaxFromPss1AEvent
   */
  @EventHandler(payloadType = UnAssignVrmaxFromPss1AEvent.class)
  public void handle(UnAssignVrmaxFromPss1AEvent event) {
    LOGGER.info("handling UnAssignVrmaxFromPss1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    Pss1A entity = unAssignVrmax(event.getPss1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss1A(entity);
  }

  /*
   * @param	event AssignVrminToPss1AEvent
   */
  @EventHandler(payloadType = AssignVrminToPss1AEvent.class)
  public void handle(AssignVrminToPss1AEvent event) {
    LOGGER.info("handling AssignVrminToPss1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    Pss1A entity = assignVrmin(event.getPss1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss1A(entity);
  }

  /*
   * @param	event UnAssignVrminFromPss1AEvent
   */
  @EventHandler(payloadType = UnAssignVrminFromPss1AEvent.class)
  public void handle(UnAssignVrminFromPss1AEvent event) {
    LOGGER.info("handling UnAssignVrminFromPss1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    Pss1A entity = unAssignVrmin(event.getPss1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss1A(entity);
  }

  /**
   * Method to retrieve the Pss1A via an Pss1APrimaryKey.
   *
   * @param id Long
   * @return Pss1A
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public Pss1A handle(FindPss1AQuery query) throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getPss1AId());
  }

  /**
   * Method to retrieve a collection of all Pss1As
   *
   * @param query FindAllPss1AQuery
   * @return List<Pss1A>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<Pss1A> handle(FindAllPss1AQuery query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindPss1A, but only if the id matches
   *
   * @param entity Pss1A
   */
  protected void emitFindPss1A(Pss1A entity) {
    LOGGER.info("handling emitFindPss1A");

    queryUpdateEmitter.emit(
        FindPss1AQuery.class,
        query -> query.getFilter().getPss1AId().equals(entity.getPss1AId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllPss1A
   *
   * @param entity Pss1A
   */
  protected void emitFindAllPss1A(Pss1A entity) {
    LOGGER.info("handling emitFindAllPss1A");

    queryUpdateEmitter.emit(FindAllPss1AQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(Pss1AProjector.class.getName());
}
