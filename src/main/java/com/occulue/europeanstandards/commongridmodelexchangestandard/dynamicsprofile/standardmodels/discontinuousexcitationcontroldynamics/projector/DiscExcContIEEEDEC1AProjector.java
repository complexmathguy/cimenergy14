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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.discontinuousexcitationcontroldynamics.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.discontinuousexcitationcontroldynamics.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Logger;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Projector for DiscExcContIEEEDEC1A as outlined for the CQRS pattern. All event handling and query
 * handling related to DiscExcContIEEEDEC1A are invoked here and dispersed as an event to be handled
 * elsewhere.
 *
 * <p>Commands are handled by DiscExcContIEEEDEC1AAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("discExcContIEEEDEC1A")
@Component("discExcContIEEEDEC1A-projector")
public class DiscExcContIEEEDEC1AProjector extends DiscExcContIEEEDEC1AEntityProjector {

  // core constructor
  public DiscExcContIEEEDEC1AProjector(
      DiscExcContIEEEDEC1ARepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateDiscExcContIEEEDEC1AEvent
   */
  @EventHandler(payloadType = CreateDiscExcContIEEEDEC1AEvent.class)
  public void handle(CreateDiscExcContIEEEDEC1AEvent event) {
    LOGGER.info("handling CreateDiscExcContIEEEDEC1AEvent - " + event);
    DiscExcContIEEEDEC1A entity = new DiscExcContIEEEDEC1A();
    entity.setDiscExcContIEEEDEC1AId(event.getDiscExcContIEEEDEC1AId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDiscExcContIEEEDEC1A(entity);
  }

  /*
   * @param	event UpdateDiscExcContIEEEDEC1AEvent
   */
  @EventHandler(payloadType = UpdateDiscExcContIEEEDEC1AEvent.class)
  public void handle(UpdateDiscExcContIEEEDEC1AEvent event) {
    LOGGER.info("handling UpdateDiscExcContIEEEDEC1AEvent - " + event);

    DiscExcContIEEEDEC1A entity = new DiscExcContIEEEDEC1A();
    entity.setDiscExcContIEEEDEC1AId(event.getDiscExcContIEEEDEC1AId());
    entity.setEsc(event.getEsc());
    entity.setKan(event.getKan());
    entity.setKetl(event.getKetl());
    entity.setTan(event.getTan());
    entity.setTd(event.getTd());
    entity.setTl1(event.getTl1());
    entity.setTl2(event.getTl2());
    entity.setTw5(event.getTw5());
    entity.setValue(event.getValue());
    entity.setVanmax(event.getVanmax());
    entity.setVomax(event.getVomax());
    entity.setVomin(event.getVomin());
    entity.setVsmax(event.getVsmax());
    entity.setVsmin(event.getVsmin());
    entity.setVtc(event.getVtc());
    entity.setVtlmt(event.getVtlmt());
    entity.setVtm(event.getVtm());
    entity.setVtn(event.getVtn());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindDiscExcContIEEEDEC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDiscExcContIEEEDEC1A(entity);
  }

  /*
   * @param	event DeleteDiscExcContIEEEDEC1AEvent
   */
  @EventHandler(payloadType = DeleteDiscExcContIEEEDEC1AEvent.class)
  public void handle(DeleteDiscExcContIEEEDEC1AEvent event) {
    LOGGER.info("handling DeleteDiscExcContIEEEDEC1AEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    DiscExcContIEEEDEC1A entity = delete(event.getDiscExcContIEEEDEC1AId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDiscExcContIEEEDEC1A(entity);
  }

  /*
   * @param	event AssignEscToDiscExcContIEEEDEC1AEvent
   */
  @EventHandler(payloadType = AssignEscToDiscExcContIEEEDEC1AEvent.class)
  public void handle(AssignEscToDiscExcContIEEEDEC1AEvent event) {
    LOGGER.info("handling AssignEscToDiscExcContIEEEDEC1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    DiscExcContIEEEDEC1A entity =
        assignEsc(event.getDiscExcContIEEEDEC1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindDiscExcContIEEEDEC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDiscExcContIEEEDEC1A(entity);
  }

  /*
   * @param	event UnAssignEscFromDiscExcContIEEEDEC1AEvent
   */
  @EventHandler(payloadType = UnAssignEscFromDiscExcContIEEEDEC1AEvent.class)
  public void handle(UnAssignEscFromDiscExcContIEEEDEC1AEvent event) {
    LOGGER.info("handling UnAssignEscFromDiscExcContIEEEDEC1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    DiscExcContIEEEDEC1A entity = unAssignEsc(event.getDiscExcContIEEEDEC1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindDiscExcContIEEEDEC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDiscExcContIEEEDEC1A(entity);
  }

  /*
   * @param	event AssignKanToDiscExcContIEEEDEC1AEvent
   */
  @EventHandler(payloadType = AssignKanToDiscExcContIEEEDEC1AEvent.class)
  public void handle(AssignKanToDiscExcContIEEEDEC1AEvent event) {
    LOGGER.info("handling AssignKanToDiscExcContIEEEDEC1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    DiscExcContIEEEDEC1A entity =
        assignKan(event.getDiscExcContIEEEDEC1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindDiscExcContIEEEDEC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDiscExcContIEEEDEC1A(entity);
  }

  /*
   * @param	event UnAssignKanFromDiscExcContIEEEDEC1AEvent
   */
  @EventHandler(payloadType = UnAssignKanFromDiscExcContIEEEDEC1AEvent.class)
  public void handle(UnAssignKanFromDiscExcContIEEEDEC1AEvent event) {
    LOGGER.info("handling UnAssignKanFromDiscExcContIEEEDEC1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    DiscExcContIEEEDEC1A entity = unAssignKan(event.getDiscExcContIEEEDEC1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindDiscExcContIEEEDEC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDiscExcContIEEEDEC1A(entity);
  }

  /*
   * @param	event AssignKetlToDiscExcContIEEEDEC1AEvent
   */
  @EventHandler(payloadType = AssignKetlToDiscExcContIEEEDEC1AEvent.class)
  public void handle(AssignKetlToDiscExcContIEEEDEC1AEvent event) {
    LOGGER.info("handling AssignKetlToDiscExcContIEEEDEC1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    DiscExcContIEEEDEC1A entity =
        assignKetl(event.getDiscExcContIEEEDEC1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindDiscExcContIEEEDEC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDiscExcContIEEEDEC1A(entity);
  }

  /*
   * @param	event UnAssignKetlFromDiscExcContIEEEDEC1AEvent
   */
  @EventHandler(payloadType = UnAssignKetlFromDiscExcContIEEEDEC1AEvent.class)
  public void handle(UnAssignKetlFromDiscExcContIEEEDEC1AEvent event) {
    LOGGER.info("handling UnAssignKetlFromDiscExcContIEEEDEC1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    DiscExcContIEEEDEC1A entity = unAssignKetl(event.getDiscExcContIEEEDEC1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindDiscExcContIEEEDEC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDiscExcContIEEEDEC1A(entity);
  }

  /*
   * @param	event AssignTanToDiscExcContIEEEDEC1AEvent
   */
  @EventHandler(payloadType = AssignTanToDiscExcContIEEEDEC1AEvent.class)
  public void handle(AssignTanToDiscExcContIEEEDEC1AEvent event) {
    LOGGER.info("handling AssignTanToDiscExcContIEEEDEC1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    DiscExcContIEEEDEC1A entity =
        assignTan(event.getDiscExcContIEEEDEC1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindDiscExcContIEEEDEC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDiscExcContIEEEDEC1A(entity);
  }

  /*
   * @param	event UnAssignTanFromDiscExcContIEEEDEC1AEvent
   */
  @EventHandler(payloadType = UnAssignTanFromDiscExcContIEEEDEC1AEvent.class)
  public void handle(UnAssignTanFromDiscExcContIEEEDEC1AEvent event) {
    LOGGER.info("handling UnAssignTanFromDiscExcContIEEEDEC1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    DiscExcContIEEEDEC1A entity = unAssignTan(event.getDiscExcContIEEEDEC1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindDiscExcContIEEEDEC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDiscExcContIEEEDEC1A(entity);
  }

  /*
   * @param	event AssignTdToDiscExcContIEEEDEC1AEvent
   */
  @EventHandler(payloadType = AssignTdToDiscExcContIEEEDEC1AEvent.class)
  public void handle(AssignTdToDiscExcContIEEEDEC1AEvent event) {
    LOGGER.info("handling AssignTdToDiscExcContIEEEDEC1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    DiscExcContIEEEDEC1A entity =
        assignTd(event.getDiscExcContIEEEDEC1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindDiscExcContIEEEDEC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDiscExcContIEEEDEC1A(entity);
  }

  /*
   * @param	event UnAssignTdFromDiscExcContIEEEDEC1AEvent
   */
  @EventHandler(payloadType = UnAssignTdFromDiscExcContIEEEDEC1AEvent.class)
  public void handle(UnAssignTdFromDiscExcContIEEEDEC1AEvent event) {
    LOGGER.info("handling UnAssignTdFromDiscExcContIEEEDEC1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    DiscExcContIEEEDEC1A entity = unAssignTd(event.getDiscExcContIEEEDEC1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindDiscExcContIEEEDEC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDiscExcContIEEEDEC1A(entity);
  }

  /*
   * @param	event AssignTl1ToDiscExcContIEEEDEC1AEvent
   */
  @EventHandler(payloadType = AssignTl1ToDiscExcContIEEEDEC1AEvent.class)
  public void handle(AssignTl1ToDiscExcContIEEEDEC1AEvent event) {
    LOGGER.info("handling AssignTl1ToDiscExcContIEEEDEC1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    DiscExcContIEEEDEC1A entity =
        assignTl1(event.getDiscExcContIEEEDEC1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindDiscExcContIEEEDEC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDiscExcContIEEEDEC1A(entity);
  }

  /*
   * @param	event UnAssignTl1FromDiscExcContIEEEDEC1AEvent
   */
  @EventHandler(payloadType = UnAssignTl1FromDiscExcContIEEEDEC1AEvent.class)
  public void handle(UnAssignTl1FromDiscExcContIEEEDEC1AEvent event) {
    LOGGER.info("handling UnAssignTl1FromDiscExcContIEEEDEC1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    DiscExcContIEEEDEC1A entity = unAssignTl1(event.getDiscExcContIEEEDEC1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindDiscExcContIEEEDEC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDiscExcContIEEEDEC1A(entity);
  }

  /*
   * @param	event AssignTl2ToDiscExcContIEEEDEC1AEvent
   */
  @EventHandler(payloadType = AssignTl2ToDiscExcContIEEEDEC1AEvent.class)
  public void handle(AssignTl2ToDiscExcContIEEEDEC1AEvent event) {
    LOGGER.info("handling AssignTl2ToDiscExcContIEEEDEC1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    DiscExcContIEEEDEC1A entity =
        assignTl2(event.getDiscExcContIEEEDEC1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindDiscExcContIEEEDEC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDiscExcContIEEEDEC1A(entity);
  }

  /*
   * @param	event UnAssignTl2FromDiscExcContIEEEDEC1AEvent
   */
  @EventHandler(payloadType = UnAssignTl2FromDiscExcContIEEEDEC1AEvent.class)
  public void handle(UnAssignTl2FromDiscExcContIEEEDEC1AEvent event) {
    LOGGER.info("handling UnAssignTl2FromDiscExcContIEEEDEC1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    DiscExcContIEEEDEC1A entity = unAssignTl2(event.getDiscExcContIEEEDEC1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindDiscExcContIEEEDEC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDiscExcContIEEEDEC1A(entity);
  }

  /*
   * @param	event AssignTw5ToDiscExcContIEEEDEC1AEvent
   */
  @EventHandler(payloadType = AssignTw5ToDiscExcContIEEEDEC1AEvent.class)
  public void handle(AssignTw5ToDiscExcContIEEEDEC1AEvent event) {
    LOGGER.info("handling AssignTw5ToDiscExcContIEEEDEC1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    DiscExcContIEEEDEC1A entity =
        assignTw5(event.getDiscExcContIEEEDEC1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindDiscExcContIEEEDEC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDiscExcContIEEEDEC1A(entity);
  }

  /*
   * @param	event UnAssignTw5FromDiscExcContIEEEDEC1AEvent
   */
  @EventHandler(payloadType = UnAssignTw5FromDiscExcContIEEEDEC1AEvent.class)
  public void handle(UnAssignTw5FromDiscExcContIEEEDEC1AEvent event) {
    LOGGER.info("handling UnAssignTw5FromDiscExcContIEEEDEC1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    DiscExcContIEEEDEC1A entity = unAssignTw5(event.getDiscExcContIEEEDEC1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindDiscExcContIEEEDEC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDiscExcContIEEEDEC1A(entity);
  }

  /*
   * @param	event AssignValueToDiscExcContIEEEDEC1AEvent
   */
  @EventHandler(payloadType = AssignValueToDiscExcContIEEEDEC1AEvent.class)
  public void handle(AssignValueToDiscExcContIEEEDEC1AEvent event) {
    LOGGER.info("handling AssignValueToDiscExcContIEEEDEC1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    DiscExcContIEEEDEC1A entity =
        assignValue(event.getDiscExcContIEEEDEC1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindDiscExcContIEEEDEC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDiscExcContIEEEDEC1A(entity);
  }

  /*
   * @param	event UnAssignValueFromDiscExcContIEEEDEC1AEvent
   */
  @EventHandler(payloadType = UnAssignValueFromDiscExcContIEEEDEC1AEvent.class)
  public void handle(UnAssignValueFromDiscExcContIEEEDEC1AEvent event) {
    LOGGER.info("handling UnAssignValueFromDiscExcContIEEEDEC1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    DiscExcContIEEEDEC1A entity = unAssignValue(event.getDiscExcContIEEEDEC1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindDiscExcContIEEEDEC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDiscExcContIEEEDEC1A(entity);
  }

  /*
   * @param	event AssignVanmaxToDiscExcContIEEEDEC1AEvent
   */
  @EventHandler(payloadType = AssignVanmaxToDiscExcContIEEEDEC1AEvent.class)
  public void handle(AssignVanmaxToDiscExcContIEEEDEC1AEvent event) {
    LOGGER.info("handling AssignVanmaxToDiscExcContIEEEDEC1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    DiscExcContIEEEDEC1A entity =
        assignVanmax(event.getDiscExcContIEEEDEC1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindDiscExcContIEEEDEC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDiscExcContIEEEDEC1A(entity);
  }

  /*
   * @param	event UnAssignVanmaxFromDiscExcContIEEEDEC1AEvent
   */
  @EventHandler(payloadType = UnAssignVanmaxFromDiscExcContIEEEDEC1AEvent.class)
  public void handle(UnAssignVanmaxFromDiscExcContIEEEDEC1AEvent event) {
    LOGGER.info("handling UnAssignVanmaxFromDiscExcContIEEEDEC1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    DiscExcContIEEEDEC1A entity = unAssignVanmax(event.getDiscExcContIEEEDEC1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindDiscExcContIEEEDEC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDiscExcContIEEEDEC1A(entity);
  }

  /*
   * @param	event AssignVomaxToDiscExcContIEEEDEC1AEvent
   */
  @EventHandler(payloadType = AssignVomaxToDiscExcContIEEEDEC1AEvent.class)
  public void handle(AssignVomaxToDiscExcContIEEEDEC1AEvent event) {
    LOGGER.info("handling AssignVomaxToDiscExcContIEEEDEC1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    DiscExcContIEEEDEC1A entity =
        assignVomax(event.getDiscExcContIEEEDEC1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindDiscExcContIEEEDEC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDiscExcContIEEEDEC1A(entity);
  }

  /*
   * @param	event UnAssignVomaxFromDiscExcContIEEEDEC1AEvent
   */
  @EventHandler(payloadType = UnAssignVomaxFromDiscExcContIEEEDEC1AEvent.class)
  public void handle(UnAssignVomaxFromDiscExcContIEEEDEC1AEvent event) {
    LOGGER.info("handling UnAssignVomaxFromDiscExcContIEEEDEC1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    DiscExcContIEEEDEC1A entity = unAssignVomax(event.getDiscExcContIEEEDEC1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindDiscExcContIEEEDEC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDiscExcContIEEEDEC1A(entity);
  }

  /*
   * @param	event AssignVominToDiscExcContIEEEDEC1AEvent
   */
  @EventHandler(payloadType = AssignVominToDiscExcContIEEEDEC1AEvent.class)
  public void handle(AssignVominToDiscExcContIEEEDEC1AEvent event) {
    LOGGER.info("handling AssignVominToDiscExcContIEEEDEC1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    DiscExcContIEEEDEC1A entity =
        assignVomin(event.getDiscExcContIEEEDEC1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindDiscExcContIEEEDEC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDiscExcContIEEEDEC1A(entity);
  }

  /*
   * @param	event UnAssignVominFromDiscExcContIEEEDEC1AEvent
   */
  @EventHandler(payloadType = UnAssignVominFromDiscExcContIEEEDEC1AEvent.class)
  public void handle(UnAssignVominFromDiscExcContIEEEDEC1AEvent event) {
    LOGGER.info("handling UnAssignVominFromDiscExcContIEEEDEC1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    DiscExcContIEEEDEC1A entity = unAssignVomin(event.getDiscExcContIEEEDEC1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindDiscExcContIEEEDEC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDiscExcContIEEEDEC1A(entity);
  }

  /*
   * @param	event AssignVsmaxToDiscExcContIEEEDEC1AEvent
   */
  @EventHandler(payloadType = AssignVsmaxToDiscExcContIEEEDEC1AEvent.class)
  public void handle(AssignVsmaxToDiscExcContIEEEDEC1AEvent event) {
    LOGGER.info("handling AssignVsmaxToDiscExcContIEEEDEC1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    DiscExcContIEEEDEC1A entity =
        assignVsmax(event.getDiscExcContIEEEDEC1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindDiscExcContIEEEDEC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDiscExcContIEEEDEC1A(entity);
  }

  /*
   * @param	event UnAssignVsmaxFromDiscExcContIEEEDEC1AEvent
   */
  @EventHandler(payloadType = UnAssignVsmaxFromDiscExcContIEEEDEC1AEvent.class)
  public void handle(UnAssignVsmaxFromDiscExcContIEEEDEC1AEvent event) {
    LOGGER.info("handling UnAssignVsmaxFromDiscExcContIEEEDEC1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    DiscExcContIEEEDEC1A entity = unAssignVsmax(event.getDiscExcContIEEEDEC1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindDiscExcContIEEEDEC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDiscExcContIEEEDEC1A(entity);
  }

  /*
   * @param	event AssignVsminToDiscExcContIEEEDEC1AEvent
   */
  @EventHandler(payloadType = AssignVsminToDiscExcContIEEEDEC1AEvent.class)
  public void handle(AssignVsminToDiscExcContIEEEDEC1AEvent event) {
    LOGGER.info("handling AssignVsminToDiscExcContIEEEDEC1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    DiscExcContIEEEDEC1A entity =
        assignVsmin(event.getDiscExcContIEEEDEC1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindDiscExcContIEEEDEC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDiscExcContIEEEDEC1A(entity);
  }

  /*
   * @param	event UnAssignVsminFromDiscExcContIEEEDEC1AEvent
   */
  @EventHandler(payloadType = UnAssignVsminFromDiscExcContIEEEDEC1AEvent.class)
  public void handle(UnAssignVsminFromDiscExcContIEEEDEC1AEvent event) {
    LOGGER.info("handling UnAssignVsminFromDiscExcContIEEEDEC1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    DiscExcContIEEEDEC1A entity = unAssignVsmin(event.getDiscExcContIEEEDEC1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindDiscExcContIEEEDEC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDiscExcContIEEEDEC1A(entity);
  }

  /*
   * @param	event AssignVtcToDiscExcContIEEEDEC1AEvent
   */
  @EventHandler(payloadType = AssignVtcToDiscExcContIEEEDEC1AEvent.class)
  public void handle(AssignVtcToDiscExcContIEEEDEC1AEvent event) {
    LOGGER.info("handling AssignVtcToDiscExcContIEEEDEC1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    DiscExcContIEEEDEC1A entity =
        assignVtc(event.getDiscExcContIEEEDEC1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindDiscExcContIEEEDEC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDiscExcContIEEEDEC1A(entity);
  }

  /*
   * @param	event UnAssignVtcFromDiscExcContIEEEDEC1AEvent
   */
  @EventHandler(payloadType = UnAssignVtcFromDiscExcContIEEEDEC1AEvent.class)
  public void handle(UnAssignVtcFromDiscExcContIEEEDEC1AEvent event) {
    LOGGER.info("handling UnAssignVtcFromDiscExcContIEEEDEC1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    DiscExcContIEEEDEC1A entity = unAssignVtc(event.getDiscExcContIEEEDEC1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindDiscExcContIEEEDEC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDiscExcContIEEEDEC1A(entity);
  }

  /*
   * @param	event AssignVtlmtToDiscExcContIEEEDEC1AEvent
   */
  @EventHandler(payloadType = AssignVtlmtToDiscExcContIEEEDEC1AEvent.class)
  public void handle(AssignVtlmtToDiscExcContIEEEDEC1AEvent event) {
    LOGGER.info("handling AssignVtlmtToDiscExcContIEEEDEC1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    DiscExcContIEEEDEC1A entity =
        assignVtlmt(event.getDiscExcContIEEEDEC1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindDiscExcContIEEEDEC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDiscExcContIEEEDEC1A(entity);
  }

  /*
   * @param	event UnAssignVtlmtFromDiscExcContIEEEDEC1AEvent
   */
  @EventHandler(payloadType = UnAssignVtlmtFromDiscExcContIEEEDEC1AEvent.class)
  public void handle(UnAssignVtlmtFromDiscExcContIEEEDEC1AEvent event) {
    LOGGER.info("handling UnAssignVtlmtFromDiscExcContIEEEDEC1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    DiscExcContIEEEDEC1A entity = unAssignVtlmt(event.getDiscExcContIEEEDEC1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindDiscExcContIEEEDEC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDiscExcContIEEEDEC1A(entity);
  }

  /*
   * @param	event AssignVtmToDiscExcContIEEEDEC1AEvent
   */
  @EventHandler(payloadType = AssignVtmToDiscExcContIEEEDEC1AEvent.class)
  public void handle(AssignVtmToDiscExcContIEEEDEC1AEvent event) {
    LOGGER.info("handling AssignVtmToDiscExcContIEEEDEC1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    DiscExcContIEEEDEC1A entity =
        assignVtm(event.getDiscExcContIEEEDEC1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindDiscExcContIEEEDEC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDiscExcContIEEEDEC1A(entity);
  }

  /*
   * @param	event UnAssignVtmFromDiscExcContIEEEDEC1AEvent
   */
  @EventHandler(payloadType = UnAssignVtmFromDiscExcContIEEEDEC1AEvent.class)
  public void handle(UnAssignVtmFromDiscExcContIEEEDEC1AEvent event) {
    LOGGER.info("handling UnAssignVtmFromDiscExcContIEEEDEC1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    DiscExcContIEEEDEC1A entity = unAssignVtm(event.getDiscExcContIEEEDEC1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindDiscExcContIEEEDEC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDiscExcContIEEEDEC1A(entity);
  }

  /*
   * @param	event AssignVtnToDiscExcContIEEEDEC1AEvent
   */
  @EventHandler(payloadType = AssignVtnToDiscExcContIEEEDEC1AEvent.class)
  public void handle(AssignVtnToDiscExcContIEEEDEC1AEvent event) {
    LOGGER.info("handling AssignVtnToDiscExcContIEEEDEC1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    DiscExcContIEEEDEC1A entity =
        assignVtn(event.getDiscExcContIEEEDEC1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindDiscExcContIEEEDEC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDiscExcContIEEEDEC1A(entity);
  }

  /*
   * @param	event UnAssignVtnFromDiscExcContIEEEDEC1AEvent
   */
  @EventHandler(payloadType = UnAssignVtnFromDiscExcContIEEEDEC1AEvent.class)
  public void handle(UnAssignVtnFromDiscExcContIEEEDEC1AEvent event) {
    LOGGER.info("handling UnAssignVtnFromDiscExcContIEEEDEC1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    DiscExcContIEEEDEC1A entity = unAssignVtn(event.getDiscExcContIEEEDEC1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindDiscExcContIEEEDEC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDiscExcContIEEEDEC1A(entity);
  }

  /**
   * Method to retrieve the DiscExcContIEEEDEC1A via an DiscExcContIEEEDEC1APrimaryKey.
   *
   * @param id Long
   * @return DiscExcContIEEEDEC1A
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public DiscExcContIEEEDEC1A handle(FindDiscExcContIEEEDEC1AQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getDiscExcContIEEEDEC1AId());
  }

  /**
   * Method to retrieve a collection of all DiscExcContIEEEDEC1As
   *
   * @param query FindAllDiscExcContIEEEDEC1AQuery
   * @return List<DiscExcContIEEEDEC1A>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<DiscExcContIEEEDEC1A> handle(FindAllDiscExcContIEEEDEC1AQuery query)
      throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindDiscExcContIEEEDEC1A, but only if the id matches
   *
   * @param entity DiscExcContIEEEDEC1A
   */
  protected void emitFindDiscExcContIEEEDEC1A(DiscExcContIEEEDEC1A entity) {
    LOGGER.info("handling emitFindDiscExcContIEEEDEC1A");

    queryUpdateEmitter.emit(
        FindDiscExcContIEEEDEC1AQuery.class,
        query ->
            query
                .getFilter()
                .getDiscExcContIEEEDEC1AId()
                .equals(entity.getDiscExcContIEEEDEC1AId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllDiscExcContIEEEDEC1A
   *
   * @param entity DiscExcContIEEEDEC1A
   */
  protected void emitFindAllDiscExcContIEEEDEC1A(DiscExcContIEEEDEC1A entity) {
    LOGGER.info("handling emitFindAllDiscExcContIEEEDEC1A");

    queryUpdateEmitter.emit(FindAllDiscExcContIEEEDEC1AQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER =
      Logger.getLogger(DiscExcContIEEEDEC1AProjector.class.getName());
}
