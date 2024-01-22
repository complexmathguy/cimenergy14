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
package com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate;

import com.occulue.api.*;
import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.validator.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.queryhandling.QueryUpdateEmitter;

/**
 * Seconds business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of Seconds related services in the case of a Seconds business
 *       related service failing.
 *   <li>Exposes a simpler, uniform Seconds interface to the business tier, making it easy for
 *       clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill Seconds business related
 *       services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class SecondsBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public SecondsBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * Seconds Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return SecondsBusinessDelegate
   */
  public static SecondsBusinessDelegate getSecondsInstance() {
    return (new SecondsBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createSeconds(CreateSecondsCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getSecondsId() == null) command.setSecondsId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      SecondsValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateSecondsCommand - by convention the future return value for a create command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateSecondsCommand of Seconds is " + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create Seconds - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateSecondsCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateSeconds(UpdateSecondsCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      SecondsValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateSecondsCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save Seconds - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteSecondsCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteSecondsCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      SecondsValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteSecondsCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to delete Seconds using Id = " + command.getSecondsId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the Seconds via SecondsFetchOneSummary
   *
   * @param summary SecondsFetchOneSummary
   * @return SecondsFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public Seconds getSeconds(SecondsFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("SecondsFetchOneSummary arg cannot be null");

    Seconds entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      SecondsValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a Seconds
      // --------------------------------------
      CompletableFuture<Seconds> futureEntity =
          queryGateway.query(
              new FindSecondsQuery(new LoadSecondsFilter(summary.getSecondsId())),
              ResponseTypes.instanceOf(Seconds.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg = "Unable to locate Seconds with id " + summary.getSecondsId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all Secondss
   *
   * @return List<Seconds>
   * @exception ProcessingException Thrown if any problems
   */
  public List<Seconds> getAllSeconds() throws ProcessingException {
    List<Seconds> list = null;

    try {
      CompletableFuture<List<Seconds>> futureList =
          queryGateway.query(
              new FindAllSecondsQuery(), ResponseTypes.multipleInstancesOf(Seconds.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all Seconds";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign Value on Seconds
   *
   * @param command AssignValueToSecondsCommand
   * @exception ProcessingException
   */
  public void assignValue(AssignValueToSecondsCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getSecondsId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .FloatProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .FloatProxyBusinessDelegate.getFloatProxyInstance();
    SecondsBusinessDelegate parentDelegate = SecondsBusinessDelegate.getSecondsInstance();
    UUID childId = command.getAssignment().getFloatProxyId();
    FloatProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      SecondsValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get FloatProxy using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign Value on Seconds
   *
   * @param command UnAssignValueFromSecondsCommand
   * @exception ProcessingException
   */
  public void unAssignValue(UnAssignValueFromSecondsCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      SecondsValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Value on Seconds";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return Seconds
   */
  private Seconds load(UUID id) throws ProcessingException {
    seconds =
        SecondsBusinessDelegate.getSecondsInstance().getSeconds(new SecondsFetchOneSummary(id));
    return seconds;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private Seconds seconds = null;
  private static final Logger LOGGER = Logger.getLogger(SecondsBusinessDelegate.class.getName());
}
