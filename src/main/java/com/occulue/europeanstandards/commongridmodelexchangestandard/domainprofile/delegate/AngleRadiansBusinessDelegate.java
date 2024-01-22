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
 * AngleRadians business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of AngleRadians related services in the case of a AngleRadians
 *       business related service failing.
 *   <li>Exposes a simpler, uniform AngleRadians interface to the business tier, making it easy for
 *       clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill AngleRadians business
 *       related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class AngleRadiansBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public AngleRadiansBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * AngleRadians Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return AngleRadiansBusinessDelegate
   */
  public static AngleRadiansBusinessDelegate getAngleRadiansInstance() {
    return (new AngleRadiansBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createAngleRadians(CreateAngleRadiansCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getAngleRadiansId() == null) command.setAngleRadiansId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      AngleRadiansValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateAngleRadiansCommand - by convention the future return value for a create
      // command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateAngleRadiansCommand of AngleRadians is "
              + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create AngleRadians - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateAngleRadiansCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateAngleRadians(UpdateAngleRadiansCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      AngleRadiansValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateAngleRadiansCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save AngleRadians - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteAngleRadiansCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteAngleRadiansCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      AngleRadiansValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteAngleRadiansCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg =
          "Unable to delete AngleRadians using Id = " + command.getAngleRadiansId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the AngleRadians via AngleRadiansFetchOneSummary
   *
   * @param summary AngleRadiansFetchOneSummary
   * @return AngleRadiansFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public AngleRadians getAngleRadians(AngleRadiansFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("AngleRadiansFetchOneSummary arg cannot be null");

    AngleRadians entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      AngleRadiansValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a AngleRadians
      // --------------------------------------
      CompletableFuture<AngleRadians> futureEntity =
          queryGateway.query(
              new FindAngleRadiansQuery(new LoadAngleRadiansFilter(summary.getAngleRadiansId())),
              ResponseTypes.instanceOf(AngleRadians.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg = "Unable to locate AngleRadians with id " + summary.getAngleRadiansId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all AngleRadianss
   *
   * @return List<AngleRadians>
   * @exception ProcessingException Thrown if any problems
   */
  public List<AngleRadians> getAllAngleRadians() throws ProcessingException {
    List<AngleRadians> list = null;

    try {
      CompletableFuture<List<AngleRadians>> futureList =
          queryGateway.query(
              new FindAllAngleRadiansQuery(),
              ResponseTypes.multipleInstancesOf(AngleRadians.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all AngleRadians";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign Value on AngleRadians
   *
   * @param command AssignValueToAngleRadiansCommand
   * @exception ProcessingException
   */
  public void assignValue(AssignValueToAngleRadiansCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getAngleRadiansId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .FloatProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .FloatProxyBusinessDelegate.getFloatProxyInstance();
    AngleRadiansBusinessDelegate parentDelegate =
        AngleRadiansBusinessDelegate.getAngleRadiansInstance();
    UUID childId = command.getAssignment().getFloatProxyId();
    FloatProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      AngleRadiansValidator.getInstance().validate(command);

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
   * unAssign Value on AngleRadians
   *
   * @param command UnAssignValueFromAngleRadiansCommand
   * @exception ProcessingException
   */
  public void unAssignValue(UnAssignValueFromAngleRadiansCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      AngleRadiansValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Value on AngleRadians";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return AngleRadians
   */
  private AngleRadians load(UUID id) throws ProcessingException {
    angleRadians =
        AngleRadiansBusinessDelegate.getAngleRadiansInstance()
            .getAngleRadians(new AngleRadiansFetchOneSummary(id));
    return angleRadians;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private AngleRadians angleRadians = null;
  private static final Logger LOGGER =
      Logger.getLogger(AngleRadiansBusinessDelegate.class.getName());
}
