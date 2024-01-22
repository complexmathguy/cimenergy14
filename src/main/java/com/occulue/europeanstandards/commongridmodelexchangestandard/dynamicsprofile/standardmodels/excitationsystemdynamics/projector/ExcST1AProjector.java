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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.excitationsystemdynamics.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.excitationsystemdynamics.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Logger;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Projector for ExcST1A as outlined for the CQRS pattern. All event handling and query handling
 * related to ExcST1A are invoked here and dispersed as an event to be handled elsewhere.
 *
 * <p>Commands are handled by ExcST1AAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("excST1A")
@Component("excST1A-projector")
public class ExcST1AProjector extends ExcST1AEntityProjector {

  // core constructor
  public ExcST1AProjector(ExcST1ARepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateExcST1AEvent
   */
  @EventHandler(payloadType = CreateExcST1AEvent.class)
  public void handle(CreateExcST1AEvent event) {
    LOGGER.info("handling CreateExcST1AEvent - " + event);
    ExcST1A entity = new ExcST1A();
    entity.setExcST1AId(event.getExcST1AId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST1A(entity);
  }

  /*
   * @param	event UpdateExcST1AEvent
   */
  @EventHandler(payloadType = UpdateExcST1AEvent.class)
  public void handle(UpdateExcST1AEvent event) {
    LOGGER.info("handling UpdateExcST1AEvent - " + event);

    ExcST1A entity = new ExcST1A();
    entity.setExcST1AId(event.getExcST1AId());
    entity.setIlr(event.getIlr());
    entity.setKa(event.getKa());
    entity.setKc(event.getKc());
    entity.setKf(event.getKf());
    entity.setKlr(event.getKlr());
    entity.setTa(event.getTa());
    entity.setTb(event.getTb());
    entity.setTb1(event.getTb1());
    entity.setTc(event.getTc());
    entity.setTc1(event.getTc1());
    entity.setTf(event.getTf());
    entity.setVamax(event.getVamax());
    entity.setVamin(event.getVamin());
    entity.setVimax(event.getVimax());
    entity.setVimin(event.getVimin());
    entity.setVrmax(event.getVrmax());
    entity.setVrmin(event.getVrmin());
    entity.setXe(event.getXe());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST1A(entity);
  }

  /*
   * @param	event DeleteExcST1AEvent
   */
  @EventHandler(payloadType = DeleteExcST1AEvent.class)
  public void handle(DeleteExcST1AEvent event) {
    LOGGER.info("handling DeleteExcST1AEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    ExcST1A entity = delete(event.getExcST1AId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST1A(entity);
  }

  /*
   * @param	event AssignIlrToExcST1AEvent
   */
  @EventHandler(payloadType = AssignIlrToExcST1AEvent.class)
  public void handle(AssignIlrToExcST1AEvent event) {
    LOGGER.info("handling AssignIlrToExcST1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcST1A entity = assignIlr(event.getExcST1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST1A(entity);
  }

  /*
   * @param	event UnAssignIlrFromExcST1AEvent
   */
  @EventHandler(payloadType = UnAssignIlrFromExcST1AEvent.class)
  public void handle(UnAssignIlrFromExcST1AEvent event) {
    LOGGER.info("handling UnAssignIlrFromExcST1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcST1A entity = unAssignIlr(event.getExcST1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST1A(entity);
  }

  /*
   * @param	event AssignKaToExcST1AEvent
   */
  @EventHandler(payloadType = AssignKaToExcST1AEvent.class)
  public void handle(AssignKaToExcST1AEvent event) {
    LOGGER.info("handling AssignKaToExcST1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcST1A entity = assignKa(event.getExcST1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST1A(entity);
  }

  /*
   * @param	event UnAssignKaFromExcST1AEvent
   */
  @EventHandler(payloadType = UnAssignKaFromExcST1AEvent.class)
  public void handle(UnAssignKaFromExcST1AEvent event) {
    LOGGER.info("handling UnAssignKaFromExcST1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcST1A entity = unAssignKa(event.getExcST1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST1A(entity);
  }

  /*
   * @param	event AssignKcToExcST1AEvent
   */
  @EventHandler(payloadType = AssignKcToExcST1AEvent.class)
  public void handle(AssignKcToExcST1AEvent event) {
    LOGGER.info("handling AssignKcToExcST1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcST1A entity = assignKc(event.getExcST1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST1A(entity);
  }

  /*
   * @param	event UnAssignKcFromExcST1AEvent
   */
  @EventHandler(payloadType = UnAssignKcFromExcST1AEvent.class)
  public void handle(UnAssignKcFromExcST1AEvent event) {
    LOGGER.info("handling UnAssignKcFromExcST1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcST1A entity = unAssignKc(event.getExcST1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST1A(entity);
  }

  /*
   * @param	event AssignKfToExcST1AEvent
   */
  @EventHandler(payloadType = AssignKfToExcST1AEvent.class)
  public void handle(AssignKfToExcST1AEvent event) {
    LOGGER.info("handling AssignKfToExcST1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcST1A entity = assignKf(event.getExcST1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST1A(entity);
  }

  /*
   * @param	event UnAssignKfFromExcST1AEvent
   */
  @EventHandler(payloadType = UnAssignKfFromExcST1AEvent.class)
  public void handle(UnAssignKfFromExcST1AEvent event) {
    LOGGER.info("handling UnAssignKfFromExcST1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcST1A entity = unAssignKf(event.getExcST1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST1A(entity);
  }

  /*
   * @param	event AssignKlrToExcST1AEvent
   */
  @EventHandler(payloadType = AssignKlrToExcST1AEvent.class)
  public void handle(AssignKlrToExcST1AEvent event) {
    LOGGER.info("handling AssignKlrToExcST1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcST1A entity = assignKlr(event.getExcST1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST1A(entity);
  }

  /*
   * @param	event UnAssignKlrFromExcST1AEvent
   */
  @EventHandler(payloadType = UnAssignKlrFromExcST1AEvent.class)
  public void handle(UnAssignKlrFromExcST1AEvent event) {
    LOGGER.info("handling UnAssignKlrFromExcST1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcST1A entity = unAssignKlr(event.getExcST1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST1A(entity);
  }

  /*
   * @param	event AssignTaToExcST1AEvent
   */
  @EventHandler(payloadType = AssignTaToExcST1AEvent.class)
  public void handle(AssignTaToExcST1AEvent event) {
    LOGGER.info("handling AssignTaToExcST1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcST1A entity = assignTa(event.getExcST1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST1A(entity);
  }

  /*
   * @param	event UnAssignTaFromExcST1AEvent
   */
  @EventHandler(payloadType = UnAssignTaFromExcST1AEvent.class)
  public void handle(UnAssignTaFromExcST1AEvent event) {
    LOGGER.info("handling UnAssignTaFromExcST1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcST1A entity = unAssignTa(event.getExcST1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST1A(entity);
  }

  /*
   * @param	event AssignTbToExcST1AEvent
   */
  @EventHandler(payloadType = AssignTbToExcST1AEvent.class)
  public void handle(AssignTbToExcST1AEvent event) {
    LOGGER.info("handling AssignTbToExcST1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcST1A entity = assignTb(event.getExcST1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST1A(entity);
  }

  /*
   * @param	event UnAssignTbFromExcST1AEvent
   */
  @EventHandler(payloadType = UnAssignTbFromExcST1AEvent.class)
  public void handle(UnAssignTbFromExcST1AEvent event) {
    LOGGER.info("handling UnAssignTbFromExcST1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcST1A entity = unAssignTb(event.getExcST1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST1A(entity);
  }

  /*
   * @param	event AssignTb1ToExcST1AEvent
   */
  @EventHandler(payloadType = AssignTb1ToExcST1AEvent.class)
  public void handle(AssignTb1ToExcST1AEvent event) {
    LOGGER.info("handling AssignTb1ToExcST1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcST1A entity = assignTb1(event.getExcST1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST1A(entity);
  }

  /*
   * @param	event UnAssignTb1FromExcST1AEvent
   */
  @EventHandler(payloadType = UnAssignTb1FromExcST1AEvent.class)
  public void handle(UnAssignTb1FromExcST1AEvent event) {
    LOGGER.info("handling UnAssignTb1FromExcST1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcST1A entity = unAssignTb1(event.getExcST1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST1A(entity);
  }

  /*
   * @param	event AssignTcToExcST1AEvent
   */
  @EventHandler(payloadType = AssignTcToExcST1AEvent.class)
  public void handle(AssignTcToExcST1AEvent event) {
    LOGGER.info("handling AssignTcToExcST1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcST1A entity = assignTc(event.getExcST1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST1A(entity);
  }

  /*
   * @param	event UnAssignTcFromExcST1AEvent
   */
  @EventHandler(payloadType = UnAssignTcFromExcST1AEvent.class)
  public void handle(UnAssignTcFromExcST1AEvent event) {
    LOGGER.info("handling UnAssignTcFromExcST1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcST1A entity = unAssignTc(event.getExcST1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST1A(entity);
  }

  /*
   * @param	event AssignTc1ToExcST1AEvent
   */
  @EventHandler(payloadType = AssignTc1ToExcST1AEvent.class)
  public void handle(AssignTc1ToExcST1AEvent event) {
    LOGGER.info("handling AssignTc1ToExcST1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcST1A entity = assignTc1(event.getExcST1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST1A(entity);
  }

  /*
   * @param	event UnAssignTc1FromExcST1AEvent
   */
  @EventHandler(payloadType = UnAssignTc1FromExcST1AEvent.class)
  public void handle(UnAssignTc1FromExcST1AEvent event) {
    LOGGER.info("handling UnAssignTc1FromExcST1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcST1A entity = unAssignTc1(event.getExcST1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST1A(entity);
  }

  /*
   * @param	event AssignTfToExcST1AEvent
   */
  @EventHandler(payloadType = AssignTfToExcST1AEvent.class)
  public void handle(AssignTfToExcST1AEvent event) {
    LOGGER.info("handling AssignTfToExcST1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcST1A entity = assignTf(event.getExcST1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST1A(entity);
  }

  /*
   * @param	event UnAssignTfFromExcST1AEvent
   */
  @EventHandler(payloadType = UnAssignTfFromExcST1AEvent.class)
  public void handle(UnAssignTfFromExcST1AEvent event) {
    LOGGER.info("handling UnAssignTfFromExcST1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcST1A entity = unAssignTf(event.getExcST1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST1A(entity);
  }

  /*
   * @param	event AssignVamaxToExcST1AEvent
   */
  @EventHandler(payloadType = AssignVamaxToExcST1AEvent.class)
  public void handle(AssignVamaxToExcST1AEvent event) {
    LOGGER.info("handling AssignVamaxToExcST1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcST1A entity = assignVamax(event.getExcST1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST1A(entity);
  }

  /*
   * @param	event UnAssignVamaxFromExcST1AEvent
   */
  @EventHandler(payloadType = UnAssignVamaxFromExcST1AEvent.class)
  public void handle(UnAssignVamaxFromExcST1AEvent event) {
    LOGGER.info("handling UnAssignVamaxFromExcST1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcST1A entity = unAssignVamax(event.getExcST1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST1A(entity);
  }

  /*
   * @param	event AssignVaminToExcST1AEvent
   */
  @EventHandler(payloadType = AssignVaminToExcST1AEvent.class)
  public void handle(AssignVaminToExcST1AEvent event) {
    LOGGER.info("handling AssignVaminToExcST1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcST1A entity = assignVamin(event.getExcST1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST1A(entity);
  }

  /*
   * @param	event UnAssignVaminFromExcST1AEvent
   */
  @EventHandler(payloadType = UnAssignVaminFromExcST1AEvent.class)
  public void handle(UnAssignVaminFromExcST1AEvent event) {
    LOGGER.info("handling UnAssignVaminFromExcST1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcST1A entity = unAssignVamin(event.getExcST1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST1A(entity);
  }

  /*
   * @param	event AssignVimaxToExcST1AEvent
   */
  @EventHandler(payloadType = AssignVimaxToExcST1AEvent.class)
  public void handle(AssignVimaxToExcST1AEvent event) {
    LOGGER.info("handling AssignVimaxToExcST1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcST1A entity = assignVimax(event.getExcST1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST1A(entity);
  }

  /*
   * @param	event UnAssignVimaxFromExcST1AEvent
   */
  @EventHandler(payloadType = UnAssignVimaxFromExcST1AEvent.class)
  public void handle(UnAssignVimaxFromExcST1AEvent event) {
    LOGGER.info("handling UnAssignVimaxFromExcST1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcST1A entity = unAssignVimax(event.getExcST1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST1A(entity);
  }

  /*
   * @param	event AssignViminToExcST1AEvent
   */
  @EventHandler(payloadType = AssignViminToExcST1AEvent.class)
  public void handle(AssignViminToExcST1AEvent event) {
    LOGGER.info("handling AssignViminToExcST1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcST1A entity = assignVimin(event.getExcST1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST1A(entity);
  }

  /*
   * @param	event UnAssignViminFromExcST1AEvent
   */
  @EventHandler(payloadType = UnAssignViminFromExcST1AEvent.class)
  public void handle(UnAssignViminFromExcST1AEvent event) {
    LOGGER.info("handling UnAssignViminFromExcST1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcST1A entity = unAssignVimin(event.getExcST1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST1A(entity);
  }

  /*
   * @param	event AssignVrmaxToExcST1AEvent
   */
  @EventHandler(payloadType = AssignVrmaxToExcST1AEvent.class)
  public void handle(AssignVrmaxToExcST1AEvent event) {
    LOGGER.info("handling AssignVrmaxToExcST1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcST1A entity = assignVrmax(event.getExcST1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST1A(entity);
  }

  /*
   * @param	event UnAssignVrmaxFromExcST1AEvent
   */
  @EventHandler(payloadType = UnAssignVrmaxFromExcST1AEvent.class)
  public void handle(UnAssignVrmaxFromExcST1AEvent event) {
    LOGGER.info("handling UnAssignVrmaxFromExcST1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcST1A entity = unAssignVrmax(event.getExcST1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST1A(entity);
  }

  /*
   * @param	event AssignVrminToExcST1AEvent
   */
  @EventHandler(payloadType = AssignVrminToExcST1AEvent.class)
  public void handle(AssignVrminToExcST1AEvent event) {
    LOGGER.info("handling AssignVrminToExcST1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcST1A entity = assignVrmin(event.getExcST1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST1A(entity);
  }

  /*
   * @param	event UnAssignVrminFromExcST1AEvent
   */
  @EventHandler(payloadType = UnAssignVrminFromExcST1AEvent.class)
  public void handle(UnAssignVrminFromExcST1AEvent event) {
    LOGGER.info("handling UnAssignVrminFromExcST1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcST1A entity = unAssignVrmin(event.getExcST1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST1A(entity);
  }

  /*
   * @param	event AssignXeToExcST1AEvent
   */
  @EventHandler(payloadType = AssignXeToExcST1AEvent.class)
  public void handle(AssignXeToExcST1AEvent event) {
    LOGGER.info("handling AssignXeToExcST1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcST1A entity = assignXe(event.getExcST1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST1A(entity);
  }

  /*
   * @param	event UnAssignXeFromExcST1AEvent
   */
  @EventHandler(payloadType = UnAssignXeFromExcST1AEvent.class)
  public void handle(UnAssignXeFromExcST1AEvent event) {
    LOGGER.info("handling UnAssignXeFromExcST1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcST1A entity = unAssignXe(event.getExcST1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST1A(entity);
  }

  /**
   * Method to retrieve the ExcST1A via an ExcST1APrimaryKey.
   *
   * @param id Long
   * @return ExcST1A
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public ExcST1A handle(FindExcST1AQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getExcST1AId());
  }

  /**
   * Method to retrieve a collection of all ExcST1As
   *
   * @param query FindAllExcST1AQuery
   * @return List<ExcST1A>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<ExcST1A> handle(FindAllExcST1AQuery query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindExcST1A, but only if the id matches
   *
   * @param entity ExcST1A
   */
  protected void emitFindExcST1A(ExcST1A entity) {
    LOGGER.info("handling emitFindExcST1A");

    queryUpdateEmitter.emit(
        FindExcST1AQuery.class,
        query -> query.getFilter().getExcST1AId().equals(entity.getExcST1AId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllExcST1A
   *
   * @param entity ExcST1A
   */
  protected void emitFindAllExcST1A(ExcST1A entity) {
    LOGGER.info("handling emitFindAllExcST1A");

    queryUpdateEmitter.emit(FindAllExcST1AQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(ExcST1AProjector.class.getName());
}
